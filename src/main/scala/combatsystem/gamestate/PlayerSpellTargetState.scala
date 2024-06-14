package combatsystem.gamestate

import spells.{DarkSpell, LightSpell}
import unit.MagicAlly

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

}
