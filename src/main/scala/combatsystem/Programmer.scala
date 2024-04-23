package combatsystem
import unit.{Enemy, ICharacter, IParty, Units}

import scala.collection.mutable.ListBuffer

class Programmer(var party: IParty, val enemies: ListBuffer[Enemy]) {
 protected var k: Int = 3
 private var readyList : ListBuffer[Units] = ListBuffer()
 party.step(0)
 for(n <- enemies) n.setActionBar(0)

 def add(who: ICharacter): Unit = {
  party.add(who)
  who.setActionBar(0)
 }

 def add(who: Enemy): Unit = {
  if(enemies.length < 5){
   enemies.addOne(who)
   who.setActionBar(0)
  }
 }

 def step() : Unit = {
  party.step(k)
  for(n <- enemies) n.setActionBar(k)
 }

 def anyTurn : Boolean = {
  readyList.clear()
  if(party.member1.getActionBar > 0) readyList.addOne(party.member1)
  if(party.member2.getActionBar > 0) readyList.addOne(party.member2)
  if(party.member3.getActionBar > 0) readyList.addOne(party.member3)
  for(n <- enemies){
   if(n.getActionBar > 0) readyList.addOne(n)
  }

  if(readyList.nonEmpty) true
  else false
 }

 def getTurn : Units = {
  readyList = readyList.sortWith(_.getActionBar < _.getActionBar)
  val result : Units = readyList.last
  readyList.last.setActionBar(0)
  readyList.dropRightInPlace(1)
  result
 }

}