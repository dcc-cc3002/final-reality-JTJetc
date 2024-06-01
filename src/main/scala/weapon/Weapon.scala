package weapon

import unit.ICharacter

/** Trait represents common attributes shared by all weapons.
 *
 * Used by [[weapon.AbstractCommonWeapon]] and [[weapon.MagicWeapon]]
 */
trait Weapon {
  val name: String
  val damage: Int
  val weight: Double
  protected var owner: ICharacter
  val magic_damage : Int

  /** Returns the owner of the weapon; returns null if no owner (DummyCharacter) */
  def getOwner : ICharacter

  /** Checks if its valid to equip this weapon, by checking if its not being used by other
   * character and profession restrictions
   * @param who The character asking if equipping this weapon is valid
   * @return Bool if its possible or not to equip this weapon */
  def canEquipTo(who : ICharacter) : Boolean
  /** Removes the owner of the weapon; this is called after removing a weapon from a character */
  def removeOwner() : Unit
  /** Assigns this weapon owner to the corresponding character
   * @param who The character equipping this weapon
   * @throws InvalidWeaponException If trying to equip an invalid weapon for the corresponding profession
   * @throws UsedWeaponException If the weapon is already being used by someone else*/
  def equipTo(who: ICharacter) : Unit
}
