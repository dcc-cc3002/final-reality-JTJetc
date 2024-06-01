package unit

import weapon.{InvalidWeaponException, UsedWeaponException, Weapon}

/** Abstract class representing Characters.
 *
 * Used by [[unit.Character]], and [[unit.MagicCharacter]]
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.3
 */
abstract class AbstractCharacter extends ICharacter {
  /** The weapon this character is holding.
   *
   * Starts by default empty, meaning no held weapon.
   */
  protected var heldweapon: Weapon = null
  /*
  /** Placeholder method to equip a weapon */
  def placeholderEquipWeapon(weapon:Weapon) : Unit ={
    heldweapon = weapon
  }*/
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
}
