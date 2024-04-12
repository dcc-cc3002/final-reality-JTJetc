package unit

class EnemyClass(val name: String,var life:Int, var damage:Int, var defense:Int, val weight:Double) extends Enemy{
  def isAlive: Boolean = {
    if (life > 0) true
    else false
  }
}
