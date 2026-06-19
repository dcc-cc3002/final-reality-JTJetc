import scalafx.application.JFXApp3

class GamesSideWindowTest extends munit.FunSuite {

  var window : JFXApp3 = GameSideWindow

  test("Window Test"){
    var number = 0
    window.main(Array(s"This should appear in window\nThe Potato Test\nNumber ${number}"))
    for(i <- 1 to 100) {
      number += 1
    }
  }
}
