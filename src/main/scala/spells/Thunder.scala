package spells

import unit.{Enemy, MagicAlly}

import scala.util.Random

class Thunder extends DarkSpell {
  /** Name of the spell */
  val name = "Thunder"
  /** Hurts and enemy (magic_damage) and 30% to paralyse
   *
   * 20 mana cost
   * @param owner The character casting the spell
   * @param md The magic_damage of the held weapon
   * @param target The spell target
   * */
  def castSpell(owner:MagicAlly,md:Int,target:Enemy) : Unit ={
    if(owner.getMana < 20) throw new InvalidSpellException(s"${owner.getMana} mana is not enough for spell")
    owner.loseMana(20)
    target.hurtBySpell(md)
    val rand = Random.nextDouble() //0 to 1 double
    if(rand <= 0.3) {
      //target.inflictStatusEffect(new Paralysis)
    }
  }
}
