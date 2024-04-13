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
  var owner: ICharacter
}
