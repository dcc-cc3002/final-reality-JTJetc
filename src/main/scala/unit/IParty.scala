package unit

import scala.collection.mutable.ListBuffer

/** Trait mainly used for type checking.
 * Used by [[unit.Party]]
 */
trait IParty {
  protected var member1 : ICharacter
  protected var member2 : ICharacter
  protected var member3 : ICharacter
  def add(who:ICharacter): Unit
  def step(k : Int): Unit
  def remove(who:ICharacter):Unit
  def anyTurnForProgrammer(inlist:ListBuffer[Units]): ListBuffer[Units]
  def getMembers : ListBuffer[ICharacter]
}
