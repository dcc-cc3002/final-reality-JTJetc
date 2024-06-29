package combatsystem.gamestate

import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, InvalidSpellException, LightSpell}
import unit.MagicAlly
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for Player choosing target for spell game state.
 *
 * In this state, the player chooses what target to cast a spell correctly, otherwise returns to choosing
 * an action.
 * @param player The MagicCharacter in turn
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class PlayerSpellTargetState(player:MagicAlly) extends GameState {
  private var LP : LightSpell = null
  private var DP : DarkSpell = null
  def this(player:MagicAlly,spell:LightSpell) = {
    this(player)
    this.LP = spell
  }
  def this(player:MagicAlly,spell:DarkSpell) = {
    this(player)
    this.DP = spell
  }


  override def progressGame(Programmer: Programmer, weaponsList: ArrayBuffer[Weapon], darkSpells: ArrayBuffer[DarkSpell], lightSpells: ArrayBuffer[LightSpell], GameController: GameController): Unit = {

    println("0 - Cancel")
    if(LP==null){ // dark spell
      for(e <- Programmer.getEnemies.indices){
        println(s"${e+1} - " + Programmer.getEnemies(e).name + " | " + Programmer.getEnemies(e).getLife + " HP ")
      }
      val input = getInput
      try{
        if(input == 0){
          changeState(GameController, new PlayerIdleState(player.transformThisToCharacter()))
        }
        else{
          player.castSpell(DP,Programmer.getEnemies(input-1))
          println(player.transformThisToCharacter().name + " casts " + DP.name + " on " +
            Programmer.getEnemies(input-1).name)
          var check : Boolean = false
          for(ene <- Programmer.getEnemies){
            check ||= ene.isAlive
          }
          if(!check) { changeState(GameController,new VictoryState) }
          else { changeState(GameController,new NeutralState) }
        }
      }
      catch{
        case a : InvalidSpellException =>
          println(a.getMessage)
          changeState(GameController, new PlayerIdleState(player.transformThisToCharacter()))
        case b : Exception =>
          println(b.getMessage)
          changeState(GameController, new PlayerIdleState(player.transformThisToCharacter()))
      }
    }
    else{ // light spell
      if(LP.name == "Heal"){ // target allies
        for(a <- Programmer.getParty.getMembers.indices){
          println(s"${a+1} - " + Programmer.getParty.getMembers(a).name + " | " + Programmer.getParty.getMembers(a).getLife + " HP ")
        }
        val input = getInput
        try{
          if(input == 0){
            changeState(GameController, new PlayerIdleState(player.transformThisToCharacter()))
          }
          else{
            player.castSpell(LP,Programmer.getParty.getMembers(input-1))
            println(player.transformThisToCharacter().name + " casts " + LP.name + " on " +
              Programmer.getParty.getMembers(input-1).name)
            var check : Boolean = false
            for(ene <- Programmer.getEnemies){
              check ||= ene.isAlive
            }
            if(!check) { changeState(GameController,new VictoryState) }
            else { changeState(GameController,new NeutralState) }
          }
        }
        catch{
          case a : Exception =>
            println(a.getMessage)
            changeState(GameController, new PlayerIdleState(player.transformThisToCharacter()))
        }
      }
      else{ // other light spells target enemies
        for(e <- Programmer.getEnemies.indices){
          println(s"${e+1} - " + Programmer.getEnemies(e).name + " | " + Programmer.getEnemies(e).getLife + " HP ")
        }
        val input = getInput
        try{
          if(input == 0){
            changeState(GameController, new PlayerIdleState(player.transformThisToCharacter()))
          }
          else{
            player.castSpell(LP,Programmer.getEnemies(input-1))
            println(player.transformThisToCharacter().name + " casts " + LP.name + " on " +
              Programmer.getEnemies(input-1).name)
            var check : Boolean = false
            for(ene <- Programmer.getEnemies){
              check ||= ene.isAlive
            }
            if(!check) { changeState(GameController,new VictoryState) }
            else { changeState(GameController,new NeutralState) }
          }
        }
        catch{
          case a : Exception =>
            println(a.getMessage)
            changeState(GameController, new PlayerIdleState(player.transformThisToCharacter()))
        }
      }
    }

  }

}
