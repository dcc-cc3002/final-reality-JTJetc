package unit

/** Class representing a Party.
 *
 * When initializing, the slots get filled with dummy characters if no character is inputted.
 *
 * @param member1 The first member in party.
 * @param member2 The second member in party.
 * @param member3 The third member in party.
 *
 * @constructor Creates a new Party.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.2
 */
class Party(var member1: ICharacter = new DummyCharacter, var member2: ICharacter = new DummyCharacter,var member3: ICharacter = new DummyCharacter) extends IParty {

  /** Adds a member to one of the party slots
   *
   * Check member slots from 1 to 3, and if a null profession is found, it means it has a Dummy to replace with a real character.
   * Otherwise does nothing.
   *
   * @param who The character to be added to the party.
   */
  def add(who: ICharacter): Unit = {
    if (member1.profession == null) member1 = who
    else if (member2.profession == null) member2 = who
    else if (member3.profession == null) member3 = who
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
}
