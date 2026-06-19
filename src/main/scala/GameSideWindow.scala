import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.text._


object GameSideWindow extends JFXApp3 {

  var what = "0"

  override def main(args: Array[String]): Unit = {
    what = args(0)
    super.main(args)
  }
  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      width = 600
      height = 400
      title = "Battle Stats"
      scene = new Scene {
        fill = DimGrey
        content = new Text{
          text = s"${what}"
          x = 2.1
          y = 15.1
          fill = White
          font = new Font(15)
        }
      }
    }
  }
}

