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

    println("0 - Cancel")
    for(w <- weaponsList.indices){
      print(s"${w+1} - " + weaponsList(w).name + " | " + weaponsList(w).damage + " Dmg | " +
        weaponsList(w).magic_damage + " Mdm | " + weaponsList(w).weight + " Kg")
      if(weaponsList(w).getOwner == null) {  }
      else { print(" [Used by " + weaponsList(w).getOwner.name + "]") }
      println()
    }
    val input = getInput
    try {
      if(input == 0){
        changeState(GameController,new PlayerIdleState(player))
      }
      else {
        player.equipWeapon(weaponsList(input-1))
        println(player.name + " equipped " + weaponsList(input-1).name)
        changeState(GameController,new PlayerIdleState(player))
      }
    }
    catch {
      case a : Exception =>
        println(a.getMessage)
        changeState(GameController,new PlayerIdleState(player))
    }
  }

}
