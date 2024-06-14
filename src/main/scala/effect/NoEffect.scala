package effect
import unit.Enemy

/** Class representing not having a status effect.
 * @author Javier Torres
 * @since 1.1
 * @version 1.1
 */
class NoEffect extends AbstractEffect {
  def effect(who: Enemy): Boolean = { true }

  def apply(who: Enemy): Unit = { } // doesnt need it; other code is in charge of adding NoEffect

  override def end: Boolean = { false }

  protected var turns: Int = 0
}
