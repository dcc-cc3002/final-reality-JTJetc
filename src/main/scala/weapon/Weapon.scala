package weapon

trait Weapon {
  val name: String
  val damage: Int
  val weight: Double
  var owner: String
}
