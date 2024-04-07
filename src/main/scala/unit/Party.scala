package unit

class Party(var member1: ICharacter = null, var member2: ICharacter = null,var member3: ICharacter = null) {
  def add(who: ICharacter): Unit = {
    if(member1==null)member1=who
    else if(member2==null)member2=who
    else if(member3==null)member3=who
    else return
  }
}
