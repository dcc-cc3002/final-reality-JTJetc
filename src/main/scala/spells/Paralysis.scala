package spells

import unit.{MagicAlly, Units}

class Paralysis extends LightSpell {
  /** Name of the spell */
  val name = "Paralysis"
  /** Paralyse an enemy
   *
   * 25 mana cost
   * @param owner The character casting the spell
   * @param md The magic_damage of the held weapon
   * @param target The spell target
   * */
  def castSpell(owner:MagicAlly,md:Int,target:Units) : Unit ={
    if(owner.getMana < 25) throw new InvalidSpellException(s"${owner.getMana} mana is not enough for spell")
    owner.loseMana(25)
    //target.inflictStatusEffect(new Paralysis)
  }
}
