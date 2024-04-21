package unit

trait IParty {
  var member1 : ICharacter
  var member2 : ICharacter
  var member3 : ICharacter
  def add(who:ICharacter): Unit
  def step(k : Int): Unit
}
