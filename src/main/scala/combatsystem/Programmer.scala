package combatsystem
import unit.{Enemy, ICharacter, IParty, Units}

import scala.collection.mutable.ListBuffer

class Programmer(var party: IParty, val enemies: ListBuffer[Enemy]) {
 protected var k: Int = 3
 private var readyList : ListBuffer[Units] = ListBuffer()

 def add(who: ICharacter): Unit = {
  party.add(who)
 }

 def add(who: Enemy): Unit = {
  if(enemies.length < 5){
   enemies.addOne(who)
  }
 }

 def step() : Unit = {
  party.step(k)
  for(n <- enemies) n.setActionBar(k)
 }

 def anyTurn() : Boolean = {
  if(party.member1.getActionBar > 0) readyList.addOne(party.member1)
  if(party.member2.getActionBar > 0) readyList.addOne(party.member2)
  if(party.member3.getActionBar > 0) readyList.addOne(party.member3)
  for(n <- enemies) if(n.getActionBar > 0){ readyList.addOne(n) }

  if(readyList.nonEmpty) true
  else false
 }

}