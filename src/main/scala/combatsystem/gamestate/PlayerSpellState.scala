package combatsystem.gamestate

import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, LightSpell}
import unit.ICharacter
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for Player choosing which spell to cast game state.
 *
 * In this state, the player chooses a valid spell to cast, otherwise returns to choosing an action.
 * @param player The Character in turn
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class PlayerSpellState(player:ICharacter) extends GameState {

  override def progressGame(Programmer: Programmer, weaponsList: ArrayBuffer[Weapon], darkSpells: ArrayBuffer[DarkSpell], lightSpells: ArrayBuffer[LightSpell], GameController: GameController): Unit = {

    println("0 - Cancel")

    if(player.profession.name == "Black Mage"){
      for(s <- darkSpells.indices){
        print(s"${s+1} - " + darkSpells(s).name + " | " + darkSpells(s).cost + " Mana")
        println()
      }
      val input = getInput
      try {
        if(input == 0){
          changeState(GameController,new PlayerIdleState(player))
        }
        else{
          val choice : DarkSpell = darkSpells(input-1)
          changeState(GameController, new PlayerSpellTargetState(player.transformThisToMagicAlly(),choice))
        }
      }
      catch {
        case a : Exception =>
          println(a.getMessage)
          changeState(GameController,new PlayerIdleState(player))
      }
    }

    else{ // "White Mage"
      for(s <- lightSpells.indices){
        print(s"${s+1} - " + lightSpells(s).name + " | " + lightSpells(s).cost + " Mana")
        println()
      }
      val input = getInput
      try {
        if(input == 0){
          changeState(GameController,new PlayerIdleState(player))
        }
        else{
          val choice : LightSpell = lightSpells(input-1)
          changeState(GameController, new PlayerSpellTargetState(player.transformThisToMagicAlly(),choice))
        }
      }
      catch {
        case a : Exception =>
          println(a.getMessage)
          changeState(GameController,new PlayerIdleState(player))
      }
    }

  }

}
