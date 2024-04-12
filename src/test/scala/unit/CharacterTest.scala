package unit

import profession.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}

class CharacterTest extends munit.FunSuite {
  var trainer: Character = _
  var trainer2: Character = _
  var magic_trainer: MagicCharacter = _
  var magic_trainer2: MagicCharacter = _
  var weak_character: Character = _
  var weak_character2: MagicCharacter = _
  var weak_character3: MagicCharacter = _
  var AliveParty: Party = _
  var DeathParty: Party = _
  var some_enemy: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    trainer = new Character("TrainerOne", 100, 50, 32.5, new Paladin)
    trainer2 = new Character("TrainerTwo", 100, 50, 50, new Warrior)
    magic_trainer = new MagicCharacter("magic", 20, 5, 25, new BlackMage, 1000)
    magic_trainer2 = new MagicCharacter(profession = new BlackMage,mana=1)
    weak_character = new Character("Weak characterOne", 100, 30, new Ninja)
    weak_character2 = new MagicCharacter("Weak characterTwo", 100, 32.5, new WhiteMage,1)
    weak_character3 = new MagicCharacter("Weak characterThree", 100, 10, new WhiteMage,1)
    AliveParty = new Party(trainer,trainer2)
    AliveParty.add(magic_trainer)
    DeathParty = new Party(new Character(profession = new Warrior),new Character(profession = new Warrior))
    some_enemy = new EnemyClass("Bob",5,50,3,100.5)
  }
  test("Character constructor checks"){
    assertEquals(trainer.name,"TrainerOne")
    assertEquals(trainer.life,100)
    assertEquals(trainer.defense,50)
    assertEquals(trainer.weight,32.5)
    assertEquals(trainer.profession.name,new Paladin().name)
    assertEquals(trainer2.weight,50.0)
    assertEquals(trainer2.heldweapon,null)
    assertEquals(magic_trainer.name,"magic")
    assertEquals(magic_trainer.life,20)
    assertEquals(magic_trainer.defense,5)
    assertEquals(magic_trainer.weight,25.0)
    assertEquals(magic_trainer.profession.name,new BlackMage().name)
    assertEquals(magic_trainer.mana,1000)
    assertEquals(magic_trainer2.mana,1)
    assertEquals(weak_character.weight,30.0)
    assertEquals(weak_character.defense,0)
    assertEquals(weak_character2.weight,32.5)
    assertEquals(weak_character2.defense,0)
    assertEquals(weak_character3.weight,10.0)
    assertEquals(weak_character3.defense,0)
  }
  test("Party Status"){
    assertEquals(AliveParty.isAlive,true)
    assertEquals(DeathParty.isAlive,false)
  }
  test("Enemies"){
    assertEquals(some_enemy.isAlive,true)
    some_enemy.life = 0
    assertEquals(some_enemy.isAlive,false)
  }
}
