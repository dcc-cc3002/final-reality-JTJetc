package unit

trait IParty {
  def add(who:ICharacter): Unit
  def step(k : Int): Unit
}
