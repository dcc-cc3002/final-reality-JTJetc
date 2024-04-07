package unit

class Party(var member1: ICharacter = new DummyCharacter, var member2: ICharacter = new DummyCharacter,var member3: ICharacter = new DummyCharacter) {
  def add(who: ICharacter): Unit = {
    if(member1==null)member1=who
    else if(member2==null)member2=who
    else if(member3==null)member3=who
  }
  def isAlive: Boolean = {
    member1.isAlive || member2.isAlive || member3.isAlive
  }
}
