package combatsystem.gamestate

import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, LightSpell}
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

/** Abstract class for game states.
 *
 * Most methods are used in common by states, or are overridden for each case.
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
abstract class GameState extends GameStateTrait{
  /** Method to change the state of the GameController
   * @param controller The GameController
   * @param newState The new GameState */
  protected def changeState(controller: GameController, newState: GameStateTrait) : Unit = {
    controller.setState(newState)
  }

  /** Method to throw errors, mainly for me to check when something is wrong in the coding process */
  protected def error(): Nothing = throw new AssertionError(s"Something is Wrong in ${getClass.getName}")
  /** If i forget to override this in a state, this throws an error */
  def progressGame(Programmer : Programmer,weaponsList : ArrayBuffer[Weapon],darkSpells : ArrayBuffer[DarkSpell],lightSpells : ArrayBuffer[LightSpell], GameController: GameController) : Unit = error()

  def handleInput(controller: GameController): Unit = { }

  /** Method that uses StdIn to read input to integer */
  protected def getInput: Int = {
    val resp = StdIn.readLine()
    resp.toInt
  }

  def battleEnd() : Boolean = false
}
