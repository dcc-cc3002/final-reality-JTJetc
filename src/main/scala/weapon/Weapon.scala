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
}
