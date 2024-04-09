package unit

import profession.Profession

class Character(val name: String = "Unknown",var life: Int = 0,var defense: Int = 0,val weight: Double = 0.1,val profession:Profession) extends AbstractCharacter {
  def this(x: String, l: Int, w: Double, p: Profession) = {
    this(x, l, 0, w, p)
  }

  def this(x: String, l: Int, w: Int, p: Profession) = {
    this(x, l, w.toDouble, p)
  }

  def this(x: String, l: Int, d: Int, w: Int, p: Profession) = {
    this(x, l, d, w.toDouble, p)
  }

}
