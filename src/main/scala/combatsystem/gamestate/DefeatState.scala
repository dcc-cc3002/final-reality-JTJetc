package combatsystem.gamestate
import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, LightSpell}
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for Defeat game state.
 *
 * In this state, its stated that the battle ended by losing to the enemies.
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class DefeatState extends GameState {

  override def progressGame(Programmer: Programmer, weaponsList: ArrayBuffer[Weapon], darkSpells: ArrayBuffer[DarkSpell], lightSpells: ArrayBuffer[LightSpell], GameController: GameController): Unit = {

  }

  override def battleEnd(): Boolean = {
    println(" - Defeat - ")
    true
  }
}
