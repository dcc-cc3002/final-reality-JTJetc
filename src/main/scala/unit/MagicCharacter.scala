package unit

import profession.Profession

class MagicCharacter(val name: String = "Unknown", var life: Int = 0, var defense: Int = 0, val weight: Double = 0.1, val profession: Profession, var mana:Int=0) extends AbstractCharacter {

  def this(x: String, l: Int, w: Double, p: Profession, m: Int) = {
    this(x, l, 0, w, p, m)
  }

}