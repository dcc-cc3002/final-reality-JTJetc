package combatsystem

import combatsystem.gamestate._
import profession._
import spells._
import unit._
import weapon._
import effect._

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class GameControllerTest extends munit.FunSuite {
  var member1 : Character = _
  var member2 : MagicCharacter = _
  var enemy1 : EnemyClass = _
  var enemy2 : EnemyClass = _
  var enemy3 : EnemyClass = _
  var SomeParty : Party = _
  var TestTurns : Programmer = _
  val Fire : DarkSpell = new Fire
  val Thunder : DarkSpell = new Thunder
  val Paralysis : LightSpell = new Paralysis
  val Poison : LightSpell = new Poison
  val Heal : LightSpell = new Heal
  val DarkSpellsList : ArrayBuffer[DarkSpell] = ArrayBuffer[DarkSpell](Fire, Thunder)
  val LightSpellsList : ArrayBuffer[LightSpell] = ArrayBuffer[LightSpell](Paralysis,Poison,Heal)
  val WeaponsList: ArrayBuffer[Weapon] = ArrayBuffer[Weapon](new Sword("", 10, 10, new DummyCharacter))
  override def beforeEach(context: BeforeEach): Unit = {
    member1 = new Character("1",100,50,50000,new Warrior)
    member2 = new MagicCharacter("2",100,50,50000,new BlackMage, 500)
    enemy1 = new EnemyClass("Foo 1",20,100,3,100)
    enemy2 = new EnemyClass("Foo 2",10000,75,5,100)
    enemy3 = new EnemyClass("Foo 3",45,100,30,120)
    SomeParty = new Party(member1,member2)
    TestTurns = new Programmer(SomeParty,ListBuffer[Enemy](enemy1,enemy2,enemy3))
  }
  test("Enemies win"){
    enemy3.inflictStatusEffect(new ParalysisEffect)
    enemy1.inflictStatusEffect(new BurningEffect(100))
    enemy2.inflictStatusEffect(new PoisonEffect(100))
    enemy2.inflictStatusEffect(new BurningEffect(10))
    enemy2.inflictStatusEffect(new PoisonEffect(10))
    val controller: GameController = new GameController(TestTurns,WeaponsList,DarkSpellsList,LightSpellsList)
    while (!controller.battleEnd()) {
      controller.progressGame()
    }
    assertEquals(controller.battleEnd(),true)

  }
  test("Silly gameStates tests"){
    val another: GameController = new GameController(TestTurns,WeaponsList,DarkSpellsList,LightSpellsList)
    another.setState(new PlayerIdleState(member1))
    another.setState(new WeaponState(member1))
    another.setState(new PlayerAttackTargetState(member1))
    another.setState(new PlayerSpellState(member2))
    another.setState(new PlayerSpellTargetState(member2.transformThisToMagicAlly()))
    another.setState(new VictoryState)
    assertEquals(another.battleEnd(),true)

    val Au : GameStateTrait = new GameState {}
    interceptMessage[AssertionError]("Something is Wrong"){Au.progressGame(TestTurns,WeaponsList,DarkSpellsList,LightSpellsList,another)}
  }
}
