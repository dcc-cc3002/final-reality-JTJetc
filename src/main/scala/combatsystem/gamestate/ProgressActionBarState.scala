package combatsystem.gamestate
import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, LightSpell}
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for progressing the action bars game state.
 *
 * In this state, the programmer steps all units action bars.
 * an action.
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class ProgressActionBarState extends GameState {

  override def progressGame(Programmer: Programmer, weaponsList: ArrayBuffer[Weapon], darkSpells: ArrayBuffer[DarkSpell], lightSpells: ArrayBuffer[LightSpell], GameController: GameController): Unit = {

    print(".")
    Programmer.step()
    changeState(GameController,new NeutralState)
  }

}
