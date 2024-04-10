package weapon

import unit.ICharacter

trait Weapon {
  val name: String
  val damage: Int
  val weight: Double
  var owner: ICharacter
}
