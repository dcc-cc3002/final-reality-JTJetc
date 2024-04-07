package unit

class CharacterTest extends munit.FunSuite {
  var trainer: Character = _
  var trainer2: Character = _
  var magictrainer: Character = _
  var weakcharacter: Character = _
  var weakcharacter2: Character = _
  var weakcharacter3: Character = _
  var AliveParty: Party = _
  var DeathParty: Party = _

  override def beforeEach(context: BeforeEach): Unit = {
    trainer = new Character("TrainerOne", 100, 50, 32.5, "Paladin")
    trainer2 = new Character("TrainerTwo", 100, 50, 50, "Warrior")
    magictrainer = new Character("magic", 20, 5, 25, "BlackMage", 1000)
    weakcharacter = new Character("WeakcharacterOne", 100, 30, "Ninja")
    weakcharacter2 = new Character("WeakcharacterTwo", 100, 32.5, "WhiteMage",1)
    weakcharacter3 = new Character("WeakcharacterThree", 100, 10, "WhiteMage",1)
    AliveParty = new Party(trainer,trainer2)
    AliveParty.add(magictrainer)
    DeathParty = new Party(new Character(profession = "Warrior"),new Character(profession = "Warrior"))
  }
  test("Character constructor checks"){
    assertEquals(trainer.name,"TrainerOne")
    assertEquals(trainer.life,100)
    assertEquals(trainer.defense,50)
    assertEquals(trainer.weight,32.5)
    assertEquals(trainer.profession,"Paladin")
    assertEquals(trainer.mana,0)
    assertEquals(trainer2.weight,50.0)
    assertEquals(trainer2.heldweapon,null)
    assertEquals(magictrainer.name,"magic")
    assertEquals(magictrainer.life,20)
    assertEquals(magictrainer.defense,5)
    assertEquals(magictrainer.weight,25.0)
    assertEquals(magictrainer.profession,"BlackMage")
    assertEquals(magictrainer.mana,1000)
    assertEquals(weakcharacter.weight,30.0)
    assertEquals(weakcharacter.defense,0)
    assertEquals(weakcharacter2.weight,32.5)
    assertEquals(weakcharacter2.defense,0)
    assertEquals(weakcharacter3.weight,10.0)
    assertEquals(weakcharacter3.defense,0)
  }
  test("Party Status"){
    assertEquals(AliveParty.isAlive,true)
    assertEquals(DeathParty.isAlive,false)
  }
}
