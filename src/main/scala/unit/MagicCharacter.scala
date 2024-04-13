package unit

import profession.Profession

/** Class representing a Magic Character.
 *
 * When initializing, one can skip the defense value, alternative constructor defaults it to 0.
 *
 * @param name The name of the magic character.
 * @param life The life of the magic character.
 * @param defense The defense of the magic character.
 * @param weight The weight of the magic character.
 * @param profession The profession of the magic character.
 * @param mana The mana of the magic character.
 *
 * @constructor Creates a new Magic Character.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.1
 */
class MagicCharacter(val name: String = "Unknown", var life: Int = 0, var defense: Int = 0, val weight: Double = 0.1, val profession: Profession, var mana:Int=0) extends AbstractCharacter {
  /** Alternative constructor if one where to skip defense, defaulting it to 0 */
  def this(x: String, l: Int, w: Double, p: Profession, m: Int) = {
    this(x, l, 0, w, p, m)
  }

}