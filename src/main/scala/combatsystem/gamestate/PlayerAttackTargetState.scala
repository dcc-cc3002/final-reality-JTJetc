package combatsystem.gamestate

import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, LightSpell}
import unit.ICharacter
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for Player choosing a target to attack game state.
 *
 * In this state, the player chooses a valid target for a regular attack, or returns to choosing an action.
 * @param player The Character in turn
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class PlayerAttackTargetState(player:ICharacter) extends GameState {

  override def progressGame(Programmer: Programmer, weaponsList: ArrayBuffer[Weapon], darkSpells: ArrayBuffer[DarkSpell], lightSpells: ArrayBuffer[LightSpell], GameController: GameController): Unit = {

    if(player.getHeldWeapon != null){
      println("0 - Cancel")
      for(e <- Programmer.getEnemies.indices){
        println(s"${e+1} - " + Programmer.getEnemies(e).name + " | " + Programmer.getEnemies(e).getLife + " HP ")
      }
      val input = getInput
      try{
        if(input == 0){
          changeState(GameController, new PlayerIdleState(player))
        }
        else{
          if(Programmer.getEnemies(input-1).isAlive){
            player.attackAnEnemy(Programmer.getEnemies(input-1))
            println(player.name + " attacks " + Programmer.getEnemies(input-1).name)
            var check : Boolean = false
            for(ene <- Programmer.getEnemies){
              check ||= ene.isAlive
            }
            if(!check) { changeState(GameController,new VictoryState) }
            else { changeState(GameController,new NeutralState) }
          }
          else{ // death target
            println("Cant attack a death enemy")
            changeState(GameController, new PlayerIdleState(player))
          }
        }
      }
      catch{
        case a : Exception =>
          println(a.getMessage)
          changeState(GameController, new PlayerIdleState(player))
      }
    }
    else{ // no held weapon
      println("Cant attack without a held weapon")
      changeState(GameController, new PlayerIdleState(player))
    }

  }

}
