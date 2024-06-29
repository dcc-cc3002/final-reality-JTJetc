package combatsystem.gamestate
import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, LightSpell}
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for Victory game state.
 *
 * In this state, its stated the battle ended in a win.
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class VictoryState extends GameState {

  override def progressGame(Programmer: Programmer, weaponsList: ArrayBuffer[Weapon], darkSpells: ArrayBuffer[DarkSpell], lightSpells: ArrayBuffer[LightSpell], GameController: GameController): Unit = {

  }
  println(" < Victory > ")
  override def battleEnd(): Boolean = {
    true
  }

}
