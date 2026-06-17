package spells

import unit.{MagicAlly, Units}

class Poison extends LightSpell {
  /** Name of the spell */
  val name = "Poison"
  /** Poison an enemy
   *
   * 30 mana cost
   * @param owner The character casting the spell
   * @param md The magic_damage of the held weapon
   * @param target The spell target
   * */
  def castSpell(owner:MagicAlly,md:Int,target:Units) : Unit ={
    if(owner.getMana < 30) throw new InvalidSpellException(s"${owner.getMana} mana is not enough for spell")
    owner.loseMana(30)
    //target.inflictStatusEffect(new Poison(md))
  }
}
