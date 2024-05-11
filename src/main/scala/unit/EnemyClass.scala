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
 * @version 1.0.3
 */
class EnemyClass(val name: String,
                 protected var life:Int,
                 protected var damage:Int,
                 protected var defense:Int,
                 val weight:Double) extends Enemy{
  def isAlive: Boolean = {
    if (life > 0) true
    else false
  }

  /**The actionbar of the enemy, starts at zero*/
  private var actionbar : Double = 0

  /** Method that compares actionbar with weight
   *
   * @return The difference between actionbar and weight; the excess must be greater or equal to zero
   */
  def getActionBar: Double = {
    actionbar - weight
  }

  /** Method that adds k to enemy action bar.
   * In case k = 0, actionbar goes back to zero.
   *
   * @param k Amount to change actionbar
   */
  def setActionBar(k: Int): Unit = {
    if(k != 0) actionbar += k
    else actionbar = 0
  }

  def getLife: Int = life
  def getDamage: Int = damage
  def getDefense: Int = defense
}
