package unit

import effect.Effect
import weapon.{InvalidWeaponException, UsedWeaponException, Weapon}

/** Abstract class representing Characters.
 *
 * Used by [[unit.Character]], and [[unit.MagicCharacter]]
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.1
 */
abstract class AbstractCharacter extends ICharacter {
  /** The weapon this character is holding.
   *
   * Starts by default empty, meaning no held weapon.
   */
  protected var heldweapon: Weapon = null

  /** Returns the equipped weapon */
  def getHeldWeapon : Weapon = heldweapon

  def isAlive: Boolean = {
    if (life > 0) true
    else false
  }

  def getLife: Int = {
    life
  }
  def getDefense: Int ={
    defense
  }

  def attackAnEnemy(who:Enemy) : Unit = {
    if(heldweapon != null) who.hurtByCharacter(this) //nothing happens if no weapon is held
  }
  def hurtByEnemy(who:Enemy) : Unit ={
    var howMuchWillItHurt : Int = who.getDamage - defense
    if(howMuchWillItHurt < 0) howMuchWillItHurt = 0
    life -= howMuchWillItHurt
    if(life < 0) life = 0
  }

  def canEquipWeapon(weapon:Weapon) : Boolean = {
    if(weapon != null) weapon.canEquipTo(this)
    else false
  }
  def removeWeapon(): Unit = {
    if(heldweapon != null) { heldweapon.removeOwner() }
    heldweapon = null
    updateMaxActionbar()
  }
  def equipWeapon(weapon:Weapon) : Unit = {
      removeWeapon()
      weapon.equipTo(this)
      heldweapon = weapon
      updateMaxActionbar()
  }
  /** Method used for healing 30% of characters maxLife */
  def heal() : Unit = {
    var howMuch : Int = maxLife * 3 / 10
    life += howMuch
    if(life > maxLife) life = maxLife
  }

  def inflictStatusEffect(what: Effect): Unit = { } // allys dont use this method

  def isThisAnAllyTurn: Boolean = true

  def transformThisToCharacter() : ICharacter = { this }
  def transformThisToEnemy() : Enemy = { throw new AssertionError("Character is not Enemy") }

  /** Method to recover a MagicAlly type from ICharacter
   * @throws AssertionError If trying to make a regular character a magic one  */
  def transformThisToMagicAlly() : MagicAlly = { throw new AssertionError("Regular character is not magical") }
}
