package effect

import unit.Enemy

/** Class representing having Burning status effect.
 *
 * (Lose [magicDamage / 2] for 3 turns)
 *
 * @author Javier Torres
 * @since 1.1
 * @version 1.1
 */
class BurningEffect(private val magicDamage : Int) extends AbstractEffect{

  protected var turns = 3

  def effect(who : Enemy): Boolean = {
    who.hurtBySpell(magicDamage/2)
    turns -= 1
    if(!who.isAlive) false
    else true
  }

  def apply(who: Enemy): Unit = {
    who.Status(2) = this
  }

}
