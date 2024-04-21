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
 * @version 1.0.1
 */
class Character(val name: String = "Unknown",var life: Int = 0,var defense: Int = 0,val weight: Double = 0.1,val profession:Profession) extends AbstractCharacter {
  /** Alternative constructor if one where to skip defense, defaulting it to 0 */
  def this(x: String, l: Int, w: Double, p: Profession) = {
    this(x, l, 0, w, p)
  }

  private var actionbar = 0
  private var maxActionbar: Double = {
    if (heldweapon != null) weight + (heldweapon.weight / 2)
    else weight
  }

  def getActionBar: Double = {
    actionbar - maxActionbar
  }

  def setActionBar(k: Int): Unit = {
    actionbar += k
  }
}
