package combatsystem.gamestate

import combatsystem.GameController

/** In development game states */
class GameState {
  protected def changeState(controller: GameController, newState: GameState) : Unit = {
    controller.setState(newState)
  }

  protected def error(): Nothing = throw new AssertionError(s"Something is Wrong in ${getClass.getName}")
  def progressGame() : Unit = error()

  def battleEnd() : Boolean = false
}
