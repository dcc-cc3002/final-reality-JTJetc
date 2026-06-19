package unit

import profession.Profession

/** Class representing a Character.
 *
 * When initializing, one can skip the defense value, alternative constructor defaults it to 0.
 *
 * @param name The name of the character.
 * @param life The life of the character.
 * @param defense The defense of the character.
 * @param weight The weight of the character.
 * @param profession The profession of the character.
 *
 * @constructor Creates a new Character.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.2
 */
class Character(val name: String = "Unknown",var life: Int = 0,var defense: Int = 0,val weight: Double = 0.1,val profession:Profession) extends AbstractCharacter {
  /** Alternative constructor if one where to skip defense, defaulting it to 0 */
  def this(x: String, l: Int, w: Double, p: Profession) = {
    this(x, l, 0, w, p)
  }
  /**The actionbar of the character, starts at zero*/
  private var actionbar : Double = 0
  /**The threshold to complete to consider a complete actionbar and be able to get a turn*/
  private var maxActionbar: Double = {
    if (heldweapon != null) weight + (heldweapon.weight / 2)
    else weight
  }

  /** Method that compares actionbar with maxActionbar
   *
   * @return The difference between actionbar and maxActionbar
   */
  def getActionBar: Double = {
    actionbar - maxActionbar
  }

  /** Method that adds k to character action bar.
   * In case k = 0, actionbar goes back to zero.
   *
   * @param k Amount to change actionbar
   */
  def setActionBar(k: Int): Unit = {
    if(k != 0) actionbar += k
    else actionbar = 0
  }
}
