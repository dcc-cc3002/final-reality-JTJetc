package combatsystem.gamestate

import combatsystem.{GameController, Programmer}
import spells.{DarkSpell, LightSpell}
import weapon.Weapon

import scala.collection.mutable.ArrayBuffer

/** Trait used by [[GameState]] abstract class to make other GameStates */
trait GameStateTrait {
  /** Method to progress the game; each GameState should override its own method to do it
   * @param Programmer The Programmer of turns to interact with
   * @param weaponsList The available list of weapons
   * @param darkSpells The available dark spells
   * @param lightSpells The available light spells
   * @param GameController The game controller */
  def progressGame(Programmer : Programmer,weaponsList : ArrayBuffer[Weapon],darkSpells : ArrayBuffer[DarkSpell],lightSpells : ArrayBuffer[LightSpell],GameController: GameController) : Unit

  /** Method to check if the battle ended; only Defeat and Victory states should override this method */
  def battleEnd() : Boolean
}
