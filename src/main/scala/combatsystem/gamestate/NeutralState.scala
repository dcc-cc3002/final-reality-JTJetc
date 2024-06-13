package combatsystem.gamestate
import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, LightSpell}
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for Neutral game state.
 *
 * In this state, its checked that if any unit from the programmer can perform a turn, otherwise
 * we progress the action bars.
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class NeutralState extends GameState {

  override def progressGame(Programmer: Programmer, weaponsList: ArrayBuffer[Weapon], darkSpells: ArrayBuffer[DarkSpell], lightSpells: ArrayBuffer[LightSpell], GameController: GameController): Unit = {
    if(!Programmer.anyTurn) { changeState(GameController,new ProgressActionBarState) }
    else {
      val individual = Programmer.getTurn // returns "Units" type object
      if(individual.isThisAnAllyTurn) { // if true, this individual is a ICharacter
        println(individual.name + " Turn")
        changeState(GameController, new PlayerIdleState(individual.transformThisToCharacter())) //recovering type
      }
      else { // this individual is an Enemy
        println(individual.name + " Turn")
        changeState(GameController, new EnemyState(individual.transformThisToEnemy())) //recovering type
      }
    }
  }

}
