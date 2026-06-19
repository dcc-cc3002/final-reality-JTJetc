package effect

/** Abstract class for status effects
 * @author Javier Torres
 * @since 1.1
 * @version 1.1
 */
abstract class AbstractEffect extends Effect {

  /** Turns remaining for the effect */
  protected var turns : Int

  def end: Boolean = {
    if(turns<=0) true
    else false
  }

}
