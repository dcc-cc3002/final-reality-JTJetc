package spells

import unit.{MagicAlly, Units}

/** Class representing Heal light spell
 * @author Javier Torres
 * @since 1.0.8
 * @version 1.1
 */
class Heal extends LightSpell {
  /** Name of the spell */
  val name = "Heal"
  val cost = 15
  /** Heal an ally
   *
   * 15 mana cost
   * @param owner The character casting the spell
   * @param md The magic_damage of the held weapon
   * @param target The spell target
   * */
  def castSpell(owner:MagicAlly,md:Int,target:Units) : Unit ={
    //Due to MagicCharacter castSpell method, it cant heal enemies
    if(owner.getMana < cost) throw new InvalidSpellException(s"${owner.getMana} mana is not enough for heal")
    owner.loseMana(cost)
    target.heal()
  }
}
