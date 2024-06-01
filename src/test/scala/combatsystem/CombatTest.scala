package combatsystem
import profession.{BlackMage, Warrior, WhiteMage}
import unit.{Character, DummyCharacter, Enemy, EnemyClass, MagicCharacter, Party}
import weapon.{Sword, Wand}
import spells.{Fire, Heal, InvalidSpellException, Paralysis, Poison, Thunder}

import scala.collection.mutable.ListBuffer

class CombatTest extends munit.FunSuite {
  var member1 : Character = _
  var member2 : MagicCharacter = _
  var member3 : Character = _
  var member4 : MagicCharacter = _
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
    member1.equipWeapon(new Sword("Test",50,12.5,new DummyCharacter))
    member2 = new MagicCharacter("Another Dude",100,1,40.25,new BlackMage, 500)
    member2.equipWeapon(new Wand("Test2",10,12.5,new DummyCharacter, 25))
    member3 = new Character("Dude with no weapon",100,5,50.0,new Warrior)
    member4 = new MagicCharacter("Another Dude",100,1,40.25,new WhiteMage, 500)
    member4.equipWeapon(new Wand("Test3",10,12.5,new DummyCharacter, 50))
    enemy1 = new EnemyClass("Foo",20,10,3,10.0)
    enemy2 = new EnemyClass("Another Foo",30,10,5,10.5)
    enemy3 = new EnemyClass("Foo III",45,12,30,12.5)
    enemy4 = new EnemyClass("Foo Foo",75,15,15,90.5)
    enemy5 = new EnemyClass("Oof",100,25,10,120)
    enemy6 = new EnemyClass("FOO",250,100,50,250)
    SomeParty = new Party(member1)
    TestTurns = new Programmer(SomeParty,ListBuffer[Enemy](enemy1,enemy2,enemy3))
  }

  test("Programmer Adding and removing Tests"){
    TestTurns.add(member2)
    SomeParty.add(member2)
    assertEquals(TestTurns.getParty,SomeParty)
    TestTurns.add(enemy4)
    assertEquals(TestTurns.getEnemies(3),enemy4)
    TestTurns.add(enemy5)
    TestTurns.add(enemy6)
    assertEquals(TestTurns.getEnemies.last,enemy5)
    TestTurns.remove(member1)
    assertEquals(TestTurns.getParty.getMembers.head.profession,null) //Dummy Character has no profession
    TestTurns.remove(enemy3)
    assertEquals(TestTurns.getEnemies,ListBuffer[Enemy](enemy1,enemy2,enemy4,enemy5))
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
  test("Attack Tests"){ // enemies cant attack enemies, and characters cant attack characters
    member1.attackAnEnemy(enemy1)
    assertEquals(enemy1.getLife,0)
    member1.attackAnEnemy(enemy3)
    assertEquals(enemy3.getLife,25)
    member2.attackAnEnemy(enemy5)
    assertEquals(enemy5.getLife,100)
    member3.attackAnEnemy(enemy2)
    assertEquals(enemy2.getLife,30)

    enemy4.attackACharacter(member1)
    assertEquals(member1.getLife,90)
    enemy6.attackACharacter(member2)
    assertEquals(member2.getLife,1)
    enemy6.attackACharacter(member2)
    assertEquals(member2.getLife,0)
  }

  test("Spells"){ // member2 is Black Mage, member4 is White Mage
    assertEquals(member2.getMana,500)
    assertEquals(enemy2.getLife,30)
    assertEquals(enemy6.getLife,250)

    member2.castSpell(new Fire,enemy2)
    member2.castSpell(new Thunder,enemy6)

    assertEquals(member2.getMana,465)
    assertEquals(enemy2.getLife,5)
    assertEquals(enemy6.getLife,225)

    assertEquals(member4.getMana,500)
    assertEquals(member2.getLife,100)
    assertEquals(member4.getLife,100)

    enemy2.attackACharacter(member2)
    enemy6.attackACharacter(member4)
    assertEquals(member2.getLife,91)
    assertEquals(member4.getLife,1)
    member4.castSpell(new Poison,enemy2)
    member4.castSpell(new Paralysis,enemy6)
    member4.castSpell(new Heal,member2)
    member4.castSpell(new Heal,member4)

    assertEquals(member4.getMana,415)
    assertEquals(member2.getLife,100)
    assertEquals(member4.getLife,31)
  }
  test("Spell exceptions"){ // Black magic cant target allies, only enemies
    //member2 is a Black Mage and cant perform poison, which is light magic
    interceptMessage[InvalidSpellException]("Black Mage can't perform Light Magic"){member2.castSpell(new Poison, enemy4)}
    //member4 is a White Mage and cant perform fire, which is dark magic
    interceptMessage[InvalidSpellException]("White Mage can't perform Dark Magic"){member4.castSpell(new Fire,enemy6)}
    //White Mage cant cast offensive light magic on ally (in this case itself)
    interceptMessage[InvalidSpellException]("Can't cast Poison on ally"){member4.castSpell(new Poison,member4)}
    //White mage cant cast heal on enemy
    interceptMessage[InvalidSpellException]("Can't Heal an enemy"){member4.castSpell(new Heal,enemy6)}

    enemy6.attackACharacter(member2)
    enemy6.attackACharacter(member2)
    //member2 dies, and cant be healed
    interceptMessage[InvalidSpellException]("Can't heal a death ally"){member4.castSpell(new Heal,member2)}

    member2.castSpell(new Thunder,enemy1)
    //enemy1 dies, and cant be targeted by other spells
    interceptMessage[InvalidSpellException]("Can't cast on death target"){member2.castSpell(new Thunder,enemy1)}

    member2.removeWeapon()
    //with no weapon, member2 cant cast a spell
    interceptMessage[InvalidSpellException]("Need a magic weapon for casting"){member2.castSpell(new Fire, enemy6)}
    member2.equipWeapon(new Sword("Wrong Weapon",10,5.5,new DummyCharacter))
    //member2 equipping a Sword still cant perform a spell
    interceptMessage[InvalidSpellException]("Need a magic weapon for casting"){member2.castSpell(new Fire, enemy6)}

    member4.loseMana(member4.getMana-10)
    assertEquals(member4.getMana,10)
    //member4 loses almost all mana, then tries to cast a heal on itself, but there is not enough (10 out of 15)
    interceptMessage[InvalidSpellException]("10 mana is not enough for heal"){member4.castSpell(new Heal,member4)}
  }
}
