class MasterGameTest extends munit.FunSuite {


  test("Game"){
    val game = new MasterGame()
    assertEquals(game.StarterParty.isAlive,true)
    //game.run() //stuck in readline (read only/ cant make inputs in tests)
  }
}
