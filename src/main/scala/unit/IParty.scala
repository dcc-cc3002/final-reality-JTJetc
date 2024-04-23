package unit

/** Trait mainly used for type checking.
 * Used by [[unit.Party]]
 */
trait IParty {
  var member1 : ICharacter
  var member2 : ICharacter
  var member3 : ICharacter
  def add(who:ICharacter): Unit
  def step(k : Int): Unit

  def remove(who:ICharacter):Unit
}
