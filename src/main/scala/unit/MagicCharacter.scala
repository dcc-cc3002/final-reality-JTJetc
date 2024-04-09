package unit

class MagicCharacter(val name: String = "Unknown",var life: Int = 0,var defense: Int = 0,val weight: Double = 0.1,val profession: String, var mana:Int=0) extends AbstractCharacter {

  def this(x: String, l: Int, w: Double, p: String, m: Int) = {
    this(x, l, 0, w, p, m)
  }

  def this(x: String, l: Int, w: Int, p: String, m: Int) = {
    this(x, l, w.toDouble, p, m)
  }

  def this(x: String, l: Int, d: Int, w: Int, p: String, m: Int) = {
    this(x, l, d, w.toDouble, p, m)
  }
}