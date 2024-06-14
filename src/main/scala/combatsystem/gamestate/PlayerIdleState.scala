package combatsystem.gamestate

import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, LightSpell}
import unit.ICharacter
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for Player idle game state.
 *
 * In this state, the player chooses what action to perform.
 * @param player The Character in turn
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class PlayerIdleState(player:ICharacter) extends GameState {

  private var magical : Boolean = false
  if(player.profession.name == "Black Mage" || player.profession.name == "White Mage") magical = true

  override def progressGame(Programmer: Programmer, weaponsList: ArrayBuffer[Weapon], darkSpells: ArrayBuffer[DarkSpell], lightSpells: ArrayBuffer[LightSpell], GameController: GameController): Unit = {

    if(!magical){
      println("1 - Attack\n" + "2 - Equip/Switch Weapon")
      val input = getInput
      input match {
        case 1 => changeState(GameController, new PlayerAttackTargetState(player))
        case 2 => changeState(GameController, new WeaponState(player))
        case _ => println("Invalid Action")
      }
    }

    else{
      println("1 - Attack\n" + "2 - Equip/Switch Weapon\n" + "3 - Spell")
      val input = getInput
      input match {
        case 1 => changeState(GameController, new PlayerAttackTargetState(player))
        case 2 => changeState(GameController, new WeaponState(player))
        case 3 => changeState(GameController, new PlayerSpellState(player))
        case _ => println("Invalid Action")
      }
    }

  }

}
