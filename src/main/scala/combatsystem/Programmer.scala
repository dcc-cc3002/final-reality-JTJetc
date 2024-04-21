package combatsystem
import unit.{Enemy, ICharacter, IParty}

import scala.collection.mutable.ListBuffer

class Programmer(var party: IParty, val enemies: ListBuffer[Enemy]) {
 protected var k: Int = 3

 def add(who: ICharacter): Unit = {
  party.add(who)
 }

 def add(who: Enemy): Unit = {
  if(enemies.length < 5){
   enemies.addOne(who)
  }
 }

}