package unit

/** Trait mainly used for type in constructors.
 * Also provides a damage value to enemies.
 * Used by [[unit.EnemyClass]]
 */
trait Enemy extends Units{
  protected var damage: Int
  /** Returns the damage value of the enemy */
  def getDamage: Int
  /** Method that calls hurtByEnemy on target character
   * @param who The character to attack
   * */
  def attackACharacter(who:ICharacter) : Unit
  /** Method that handles taking damage from character attack
   * @param who The Character attacking the enemy
   * */
  def hurtByCharacter(who:ICharacter) : Unit
}
