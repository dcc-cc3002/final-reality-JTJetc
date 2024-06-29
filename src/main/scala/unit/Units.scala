package unit

import effect.Effect

/** Trait represents common attributes shared by playable characters and enemies.
 *
 * Used by [[unit.ICharacter]] and [[unit.Enemy]]
 */
trait Units {
  val name: String
  protected var life: Int
  protected var defense: Int
  val weight: Double
  val maxLife: Int

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
  /** Method called when healing*/
  def heal() : Unit

  /** Method that gets called when a spell inflicts a status effect to an enemy.
   *
   * Ally characters dont use this method.
   * @param what The status effect to be inflicted */
  def inflictStatusEffect(what:Effect) : Unit

  /** Method to check when a unit exits the turns programmer, if its an ally or enemy turn.
   * @return True if ally turn / False if enemy turn */
  def isThisAnAllyTurn : Boolean

  /** Method to recover the object class type after exiting the programmer as a game unit
   * @throws AssertionError If trying to make an enemy into a character */
  def transformThisToCharacter() : ICharacter
  /** Method to recover the object class type after exiting the programmer as a game unit
   * @throws AssertionError If trying to make a character into an enemy */
  def transformThisToEnemy() : Enemy
}
