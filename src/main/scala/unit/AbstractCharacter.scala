package unit

import weapon.Weapon

/** Abstract class representing Characters.
 *
 * Professions name must be provided by the subclasses.
 *
 * Used by [[unit.Character]], and [[unit.MagicCharacter]]
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.2
 */
abstract class AbstractCharacter extends ICharacter {
  /** The weapon this character is holding.
   *
   * Starts by default empty, meaning no held weapon.
   */
  protected var heldweapon: Weapon = null
  /** Placeholder method to equip a weapon */
  def placeholderEquipWeapon(weapon:Weapon) : Unit ={
    heldweapon = weapon
  }
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
}
