package combatsystem
import unit.{Enemy, ICharacter, IParty, Units}

import scala.collection.mutable.ListBuffer

/** Class representing a programmer of turns.
 *
 * Uses a [[unit.Party]] and a ListBuffer type [[unit.Enemy]] to up to 5 enemies, has many methods to ask and change the actionbar of the units, and then check and retrieve who could perform an action
 *
 * @param party A Party of Characters
 * @param enemies A ListBuffer of enemies
 *
 * @constructor Creates a new programmer for turns checking.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.1
 */
class Programmer(private var party: IParty, private val enemies: ListBuffer[Enemy]) {
 /**An arbitrary amount to increase the actionbar*/
 protected var k: Int = 3
 /**A ListBuffer to save the units that have completed their actionbars and can perform a turn, initialized empty*/
 private var readyList: ListBuffer[Units] = ListBuffer() //required to be var because otherwise cant be sorted
 //When the constructors builds, make sure to set all units actionbar to zero in case they already had some from another battle
 party.step(0)
 for (n <- enemies) n.setActionBar(0)

 /** Adds a Character to the programmer, who then makes sure add to the party and set its actionbar to zero
  *
  * @param who The character to add to the programmer
  */
 def add(who: ICharacter): Unit = {
  party.add(who)
  who.setActionBar(0)
 }

 /** Adds an enemy to the programmer, who then makes sure add to the ListBuffer and set its actionbar to zero.
  * Can only add an enemy if there is space (max 5 enemies)
  * @param who The enemy to add to the programmer
  */
 def add(who: Enemy): Unit = {
  if (enemies.length < 5) {
   enemies.addOne(who)
   who.setActionBar(0)
  }
 }

 /** Removes a specific character from the programmer, who makes sure to remove it from the party too
  *
  * @param who The character to remove from the programmer
  */
 def remove(who: ICharacter): Unit = {
  party.remove(who)
 }

 /** Removes a specific enemy from the programmer
  *
  * @param who The enemy to remove from the programmer
  */
 def remove(who: Enemy): Unit = {
    enemies -= who
 }

 /** Method to make progress in the actionbar on each party member and enemy in the ListBuffer*/
 def step(): Unit = {
  party.step(k)
  for (n <- enemies) n.setActionBar(k)
 }

 /** Checks all the units actionbars, and if they completed it, gets added to readyList ListBuffer
  *
  * @return True if any unit can perform a turn
  */
 def anyTurn: Boolean = {
  readyList.clear() //First clears the list to avoid duplicates
  readyList = party.anyTurnForProgrammer(readyList)
  for (n <- enemies) {
   if (n.getActionBar >= 0) readyList.addOne(n) //Check getActionBar in EnemyClass for more details
  }
  //If at least one unit in list, someone can perform a turn, then returns true
  if (readyList.nonEmpty) true
  else false
 }

 /**Sorts the readyList by actionbar, then extracts the one unit with more excess and resets its actionbar to zero
  *
  * @return The character or enemy that can perform an action, prioritizing the one with more excess actionbar
  */
 def getTurn: Units = {
  readyList = readyList.sortWith(_.getActionBar < _.getActionBar) //this way, the last one in list is the one with priority to have a turn
  val result = readyList.last //character or enemy to return
  readyList.last.setActionBar(0)
  readyList.dropRightInPlace(1)
  result
 }

 /** Gets the stored party
  *
  * @return The Programmer's Party
  */
 def getParty: IParty = {
  party
 }

 /** Gets the stored enemies
  *
  * @return The Programmer's Enemies List
  */
 def getEnemies: ListBuffer[Enemy] = {
  enemies
 }
}