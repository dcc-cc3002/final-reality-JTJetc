package effect

import unit.Enemy

/** Trait for the status effects */
trait Effect {
  /** Method to handle the effects of this status effect
   * @param who The enemy where the status effect occurs
   * @return Returns false if the enemy cant move, or was killed by the effect. */
  def effect(who : Enemy) : Boolean
  /** Method to apply the effect on the enemy
   * @param who The enemy to apply the status effect */
  def apply(who : Enemy) : Unit

  /** Method to check if the status effect ended */
  def end : Boolean
  /** Method to get position in status array */
  def positionInEnemy : Int
}
