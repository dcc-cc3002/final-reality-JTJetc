package unit

import effect.Effect

import scala.collection.mutable.ArrayBuffer

/** Trait mainly used for type in constructors.
 * Also provides a damage value to enemies.
 * Used by [[unit.EnemyClass]]
 */
trait Enemy extends Units{
  protected var damage: Int
  /** Returns the damage value of the enemy */
  def getDamage: Int
  /** Method that calls hurtByEnemy on target character
   * @param who The character to attack
   * */
  def attackACharacter(who:ICharacter) : Unit
  /** Method that handles taking damage from character attack
   * @param who The Character attacking the enemy
   * */
  def hurtByCharacter(who:ICharacter) : Unit

  /** Method that gets called when a spell directly harms an enemy
   * @param md The magic damage to inflict to the enemy */
  def hurtBySpell(md:Int) : Unit
  /** Method that gets called when a spell inflicts a status effect to an enemy
   * @param what The status effect to be inflicted */
  def inflictStatusEffect(what:Effect) : Unit

  /** Method to attack a random member in the allies party
   * @param party The characters party to attack */
  def attackRandom(party : IParty) : Unit

  /** List of the status effects on this enemy, starts with 3 slots with no status
   * (slots are for the 3 possible effects) */
  val Status : ArrayBuffer[Effect]
}
