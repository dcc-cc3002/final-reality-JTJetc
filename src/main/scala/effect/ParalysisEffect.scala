package effect
import unit.Enemy

/** Class representing having paralysis status effect.
 *
 * (Cant move for 1 turn / Turn gets skipped)
 * @author Javier Torres
 * @since 1.1
 * @version 1.1
 */
class ParalysisEffect extends AbstractEffect{

  protected var turns = 1

  def effect(who : Enemy): Boolean = {
    turns -= 1
    false
  }

  def apply(who: Enemy): Unit = {
    who.Status(0) = this
  }

  override def positionInEnemy: Int = 0
}
