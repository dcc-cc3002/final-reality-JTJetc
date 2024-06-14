package combatsystem.gamestate

import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, LightSpell}
import unit.ICharacter
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for Player choosing weapon to equip game state.
 *
 * In this state, the player chooses a valid weapon to equip, otherwise goes back to choosing an action.
 * @param player The Character in turn
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class WeaponState(player: ICharacter) extends GameState {

  override def progressGame(Programmer: Programmer, weaponsList: ArrayBuffer[Weapon], darkSpells: ArrayBuffer[DarkSpell], lightSpells: ArrayBuffer[LightSpell], GameController: GameController): Unit = {



  }

}
