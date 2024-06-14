package spells

import unit.{Enemy, MagicAlly}
import effect._

import scala.util.Random

/** Class representing Fire dark spell
 * @author Javier Torres
 * @since 1.0.8
 * @version 1.1
 */
class Fire extends DarkSpell {
  /** Name of the spell */
  val name = "Fire"
  val cost = 15
  /** Hurts and enemy (magic_damage) and 20% to burn
   *
   * 15 mana cost
   * @param owner The character casting the spell
   * @param md The magic_damage of the held weapon
   * @param target The spell target
   * */
  def castSpell(owner:MagicAlly, md:Int, target:Enemy) : Unit ={
    if(owner.getMana < cost) throw new InvalidSpellException(s"${owner.getMana} mana is not enough for spell")
    owner.loseMana(cost)
    target.hurtBySpell(md)
    val rand = Random.nextDouble() //0 to 1 double
    if(rand <= 0.2) {
      target.inflictStatusEffect(new BurningEffect(md))
    }
  }
}
