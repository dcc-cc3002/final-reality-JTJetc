package unit

/** Trait mainly used for type in constructors.
 * Also provides a damage value to enemies.
 * Used by [[unit.EnemyClass]]
 */
trait Enemy extends Units{
  var damage: Int
}
