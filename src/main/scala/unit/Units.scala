package unit

/** Trait represents common attributes shared by playable characters and enemies.
 *
 * Used by [[unit.ICharacter]] and [[unit.Enemy]]
 */
trait Units {
  val name: String
  protected var life: Int
  protected var defense: Int
  val weight: Double

  /** Determines if the current entity is alive.
   *
   * Checks if current life is above 0, returns true if it is, otherwise returns false.
   *
   * @return If the entity is alive
   */
  def isAlive: Boolean
  def getActionBar: Double
  def setActionBar(k : Int) : Unit
  /** Returns the life of the unit */
  def getLife : Int
  /** Returns the defense of the unit */
  def getDefense : Int
}
