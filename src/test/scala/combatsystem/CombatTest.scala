package combatsystem
import profession.{BlackMage, Warrior}
import unit.{Character, EnemyClass, MagicCharacter, Party}
import weapon.{Sword, Wand}

import scala.collection.mutable.ListBuffer

class CombatTest extends munit.FunSuite {
  var member1 : Character = _
  var member2 : MagicCharacter = _
  var enemy1 : EnemyClass = _
  var enemy2 : EnemyClass = _
  var enemy3 : EnemyClass = _
  var enemy4 : EnemyClass = _
  var enemy5 : EnemyClass = _
  var enemy6 : EnemyClass = _
  var SomeParty : Party = _
  var TestTurns : Programmer = _

  override def beforeEach(context: BeforeEach): Unit = {
    member1 = new Character("Dude",100,5,50.0,new Warrior)
    member1.heldweapon = new Sword("Test",10,12.5,member1)
    member2 = new MagicCharacter("Another Dude",100,1,40.25,new BlackMage, 500)
    member2.heldweapon = new Wand("Test",10,12.5,member2, 50)
    enemy1 = new EnemyClass("Foo",20,10,3,10.0)
    enemy2 = new EnemyClass("Another Foo",30,10,5,10.5)
    enemy3 = new EnemyClass("Foo III",45,12,30,12.5)
    enemy4 = new EnemyClass("Foo Foo",75,15,15,90.5)
    enemy5 = new EnemyClass("Oof",100,25,10,120)
    enemy6 = new EnemyClass("FOO",250,100,50,250)
    SomeParty = new Party(member1)
    TestTurns = new Programmer(SomeParty,ListBuffer(enemy1,enemy2,enemy3))
  }

  test("Programmer Adding Tests"){
    TestTurns.add(member2)
    SomeParty.add(member2)
    assertEquals(TestTurns.party,SomeParty)
    TestTurns.add(enemy4)
    assertEquals(TestTurns.enemies(3),enemy4)
    TestTurns.add(enemy5)
    TestTurns.add(enemy6)
    assertEquals(TestTurns.enemies.last,enemy5)
  }
  test("Programmer Turns Tests"){
    TestTurns.add(member2)
    TestTurns.step()
    if(TestTurns.anyTurn) TestTurns.getTurn
    assertEquals(TestTurns.anyTurn,false)
    for(i <- 0 to 50) TestTurns.step()
    assertEquals(TestTurns.anyTurn,true)
    if(TestTurns.anyTurn) assertEquals(TestTurns.getTurn,enemy1)
    if(TestTurns.anyTurn) assertEquals(TestTurns.getTurn,enemy2)
    if(TestTurns.anyTurn) assertEquals(TestTurns.getTurn,enemy3)
    if(TestTurns.anyTurn) assertEquals(TestTurns.getTurn,member2)
    if(TestTurns.anyTurn) assertEquals(TestTurns.getTurn,member1)
    assertEquals(TestTurns.anyTurn,false)
  }
}
