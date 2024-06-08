package combatsystem

import combatsystem.gamestate._

/** In development game controller */
class GameController(private val Programmer : Programmer) {
  private var state : GameState = new NeutralState()

  def setState(newState : GameState) : Unit = {
    state = newState
  }

  def progressGame() : Unit = state.progressGame()

  def battleEnd() : Boolean = state.battleEnd()

}
