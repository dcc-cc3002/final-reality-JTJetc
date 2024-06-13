package unit

import scala.collection.mutable.ListBuffer
import scala.util.Random

/** Class representing a Party.
 *
 * When initializing, the slots get filled with dummy characters if no character is inputted.
 *
 * @param member1 The first member in party.
 * @param member2 The second member in party.
 * @param member3 The third member in party.
 * @constructor Creates a new Party.
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.1
 */
class Party(protected var member1: ICharacter = new DummyCharacter,
            protected var member2: ICharacter = new DummyCharacter,
            protected var member3: ICharacter = new DummyCharacter) extends IParty {

  /** Adds a member to one of the party slots
   *
   * Check member slots from 1 to 3, and if a null profession is found, it means it has a Dummy to replace with a real character.
   *
   * @param who The character to be added to the party.
   * @throws FullPartyException When trying to add someone when party is full. (max 3 members)
   */
  def add(who: ICharacter): Unit = {
    if (member1.profession == null) member1 = who
    else if (member2.profession == null) member2 = who
    else if (member3.profession == null) member3 = who
    else throw new FullPartyException("Party is already full")
  }

  /** Determines if the party is alive.
   *
   * Calls each member isAlive method, returns true if anyone returns true.
   *
   * @return If the party is alive
   */
  def isAlive: Boolean = {
    member1.isAlive || member2.isAlive || member3.isAlive
  }

  /** Changes the actionbar of each party member by a k amount
   *
   * @param k Amount to change the actionbar
   */
  def step(k: Int): Unit = {
    member1.setActionBar(k)
    member2.setActionBar(k)
    member3.setActionBar(k)
  }

  /** Removes a specific member from the party
   *
   * @param who The Character to remove from the party
   */
  def remove(who:ICharacter):Unit={
    if(who==member3) member3 = new DummyCharacter
    if(who==member2) member2 = new DummyCharacter
    if(who==member1) member1 = new DummyCharacter
  }

  /** Using a private list in the programmer, this checks and delivers an updated list with party members with
   * filled action bars, by checking excess if it is positive (check getActionBar in Character or MagicCharacter for more details)
   *
   * @param inlist A ListBuffer with units delivered by the programmer
   * @return
   */
  def anyTurnForProgrammer(inlist:ListBuffer[Units]): ListBuffer[Units] ={
    if (member1.getActionBar >= 0) inlist.addOne(member1)
    if (member2.getActionBar >= 0) inlist.addOne(member2)
    if (member3.getActionBar >= 0) inlist.addOne(member3)
    inlist
  }

  /** Returns a ListBuffer with the Party Members */
  def getMembers : ListBuffer[ICharacter] = {
    val memberList = new ListBuffer[ICharacter]
    memberList += member1
    memberList += member2
    memberList += member3
    memberList
  }

  def becomeAttacked(enemy : Enemy): Unit = {
    val who = Random.between(0,3) // random 0 to 2 Int
    who match {
      case 0 => if(member1.profession == null || !member1.isAlive){becomeAttacked(enemy)} // re-roll if attacking dummy or death member
                else {enemy.attackACharacter(member1)}
      case 1 => if(member2.profession == null || !member2.isAlive){becomeAttacked(enemy)} // re-roll if attacking dummy or death member
                else {enemy.attackACharacter(member2)}
      case 2 => if(member3.profession == null || !member3.isAlive){becomeAttacked(enemy)} // re-roll if attacking dummy or death member
                else {enemy.attackACharacter(member3)}
    }
  }
}
