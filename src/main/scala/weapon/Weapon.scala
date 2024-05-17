package weapon

import unit.ICharacter

/** Trait represents common attributes shared by all weapons.
 *
 * Used by [[weapon.AbstractCommonWeapon]] and [[weapon.AbstractMagicWeapon]]
 */
trait Weapon {
  val name: String
  val damage: Int
  val weight: Double
  protected var owner: ICharacter

  /** Returns the owner of the weapon; returns null if no owner (DummyCharacter) */
  def getOwner : ICharacter

  /** Checks if its valid to equip this weapon, by checking if its not being used by other
   * character and profession restrictions
   * @param who The character asking if equipping this weapon is valid
   * @return Bool if its possible or not to equip this weapon */
  def canEquipTo(who : ICharacter) : Boolean
  /** Assigns this weapon owner to the corresponding character
   * @param who The character equipping this weapon
   * @throws  */
  def equipTo(who: ICharacter) : Unit
}
