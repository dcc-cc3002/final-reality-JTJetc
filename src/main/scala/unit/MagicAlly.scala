package unit

import spells.{DarkSpell, LightSpell,InvalidSpellException}

/** Trait used mainly for type checking */
trait MagicAlly {
  /** Returns the mana of the character */
  def getMana: Int
  /** Makes the character lose mana
   * @param n The quantity of mana to lose*/
  def loseMana(n:Int): Unit

  /** Cast a dark magic spell to hurt enemies
   * @param spell The DarkSpell to cast
   * @param target The enemy target
   * @throws InvalidSpellException When some condition is not met for said spell
   * */
  def castSpell(spell:DarkSpell,target:Enemy) : Unit
  /** Cast a light magic spell to inflict a status effect to an enemy
   * @param spell The LightSpell to cast
   * @param target The enemy target
   * @throws InvalidSpellException When some condition is not met for said spell
   * */
  def castSpell(spell:LightSpell,target:Enemy) : Unit
  /** Cast a heal on an ally
   * @param spell The LightSpell to cast (expected a heal)
   * @param target The ally target
   * @throws InvalidSpellException When some condition is not met for said spell
   * */
  def castSpell(spell:LightSpell,target:ICharacter) : Unit
}
