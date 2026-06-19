package combatsystem.gamestate

import combatsystem.{GameController, Programmer}
import effect.NoEffect
import spells.{DarkSpell, LightSpell}
import unit.Enemy
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for Enemy game state.
 *
 * In this state, status effects occur and the enemy attacks a random party member.
 * @param enemy The enemy in turn
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class EnemyState(enemy:Enemy) extends GameState {

  override def progressGame(Programmer: Programmer, weaponsList: ArrayBuffer[Weapon], darkSpells: ArrayBuffer[DarkSpell], lightSpells: ArrayBuffer[LightSpell], GameController: GameController): Unit = {
    var canMove : Boolean = true
    for(eff <- enemy.Status){
      canMove &&= eff.effect(enemy)
    }
    if(enemy.Status(0).end){ enemy.Status(0) = new NoEffect } //to avoid mutation occurred during iteration exception
    if(enemy.Status(1).end){ enemy.Status(1) = new NoEffect }
    if(enemy.Status(2).end){ enemy.Status(2) = new NoEffect }
    if(canMove) { // no status hinders movement capability of enemy
      println(enemy.name + " attacks")
      enemy.attackRandom(Programmer.getParty)
    }
    else { // some status returned false
      if(enemy.isAlive) println(enemy.name + " could not move")
      else println(enemy.name + " died by status effect")
    }

    if(Programmer.getParty.isAlive) {
      var check : Boolean = false
      for(ene <- Programmer.getEnemies){
        check ||= ene.isAlive
      }
      if(!check) { changeState(GameController,new VictoryState) } // last enemy died by effect
      else { changeState(GameController,new NeutralState) } // at least some enemy is still alive
    }
    else { changeState(GameController,new DefeatState) } // last party member died after attack
  }

}
