package combatsystem.gamestate

import combatsystem.GameController

/** In development game states */
class GameState {
  protected def changeState(controller: GameController, newState: GameState) : Unit = {
    controller.setState(newState)
  }

  def battleEnd() : Boolean = false
}
