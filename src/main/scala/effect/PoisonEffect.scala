package effect

import unit.Enemy

/** Class representing having poison status effect.
 *
 * (Lose [magicDamage / 3] for 4 turns)
 *
 * @author Javier Torres
 * @since 1.1
 * @version 1.1
 */
class PoisonEffect(private val magicDamage : Int) extends AbstractEffect{

  protected var turns = 4

  def effect(who : Enemy): Boolean = {
    who.hurtBySpell(magicDamage/3)
    turns -= 1
    if(!who.isAlive) false
    else true
  }

  def apply(who: Enemy): Unit = {
    who.Status(1) = this
  }

}
