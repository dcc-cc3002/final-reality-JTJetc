package unit

import effect.Effect
import exceptions.Require

/** Class representing an Enemy.
 *
 * @param name The name of the enemy.
 * @param life The life and maxLife of the enemy.
 * @param damage The damage of the enemy.
 * @param defense The defense of the enemy.
 * @param weight The weight of the enemy.
 * @constructor Creates a new Enemy.
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.4
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
  /** Max life value, initialized to the constructor life value */
  val maxLife : Int = life
  Require.Stat(life,"life") atLeast 0
  Require.Stat(defense,"defense") atLeast 0
  Require.Stat(damage,"damage") atLeast 0
  require(weight>0,"number must be greater than zero")
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

  def attackACharacter(who:ICharacter) : Unit = {
    who.hurtByEnemy(this)
  }
  def hurtByCharacter(who:ICharacter) : Unit ={
    val howMuchDamage : Int = who.getHeldWeapon.damage
    var howMuchWillItHurt : Int = howMuchDamage - defense
    if(howMuchWillItHurt < 0) howMuchWillItHurt = 0
    life -= howMuchWillItHurt
    if(life < 0) life = 0
  }
  def hurtBySpell(md:Int) : Unit = {
    life -= md
    if(life < 0) life = 0
  }
  def inflictStatusEffect(what: Effect): Unit = {
    //code that implements inflicting status effect to enemy
  }

  /** Method that may be used for strong enemies healing or something */
  def heal(): Unit = { }
}
