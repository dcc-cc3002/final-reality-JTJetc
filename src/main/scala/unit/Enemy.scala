package unit

/** Trait mainly used for type in constructors.
 * Also provides a damage value to enemies.
 * Used by [[unit.EnemyClass]]
 */
trait Enemy extends Units{
  protected var damage: Int
  /** Returns the damage value of the enemy */
  def getDamage: Int
}
