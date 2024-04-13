package unit

import weapon.Weapon

/** Abstract class representing Characters.
 *
 * Professions name must be provided by the subclasses.
 *
 * Used by [[unit.Character]], and [[unit.MagicCharacter]]
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.0
 */
abstract class AbstractCharacter extends ICharacter {
  /** The weapon this character is holding.
   *
   * Starts by default empty, meaning no held weapon.
   */
  var heldweapon: Weapon = _

  def isAlive: Boolean = {
    if (life > 0) true
    else false
  }

}
