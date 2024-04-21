package unit

/** Class representing an Enemy.
 *
 * @param name The name of the enemy.
 * @param life The life of the enemy.
 * @param damage The damage of the enemy.
 * @param defense The defense of the enemy.
 * @param weight The weight of the enemy.
 *
 * @constructor Creates a new Enemy.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.0
 */
class EnemyClass(val name: String,var life:Int, var damage:Int, var defense:Int, val weight:Double) extends Enemy{
  def isAlive: Boolean = {
    if (life > 0) true
    else false
  }

  private var actionbar = 0
  private var maxActionbar: Double = weight

  def getActionBar: Double = {
    actionbar - maxActionbar
  }

  def setActionBar(k: Int): Unit = {
    actionbar += k
  }
}
