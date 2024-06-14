package combatsystem

import combatsystem.gamestate._
import spells.{DarkSpell, LightSpell}
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class that uses States to handle the game flow
 *
 * @param Programmer The Programmer of turns
 * @param weaponsList The available list of weapons
 * @param darkSpells The available dark spells
 * @param lightSpells The available light spells
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
class GameController(private val Programmer : Programmer,
                     private val weaponsList : ArrayBuffer[Weapon],
                     private val darkSpells : ArrayBuffer[DarkSpell],
                     private val lightSpells : ArrayBuffer[LightSpell]) {
  /** Initialized with a NeutralState */
  private var state : GameStateTrait = new NeutralState()

  /** Method to change the state of the game */
  def setState(newState : GameStateTrait) : Unit = {
    state = newState
  }


  /** Method to progress the game (State dependant) */
  def progressGame() : Unit = state.progressGame(Programmer,weaponsList,darkSpells,lightSpells,this)

  /** Method to check if the battle ended (State dependant) */
  def battleEnd() : Boolean = state.battleEnd()

}
