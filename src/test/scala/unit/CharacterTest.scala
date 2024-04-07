package unit

class CharacterTest extends munit.FunSuite {
  var trainer: Character = _
  var magictrainer: Character = _
  var weakcharacter: Character = _
  var weakcharacter2: Character = _
  var weakcharacter3: Character = _

  override def beforeEach(context: BeforeEach): Unit = {
    trainer = new Character("TrainerOne", 100, 50, 32.5, "Paladin")
    magictrainer = new Character("TrainerTwo", 20, 5, 25, "BlackMage", 1000)
    weakcharacter = new Character("TrainerOne", 100, 30, "Ninja")
    weakcharacter2 = new Character("TrainerOne", 100, 32.5, "WhiteMage",1)
    weakcharacter3 = new Character("TrainerOne", 100, 10, "WhiteMage",1)
  }
  test("Character constructor checks"){
    assertEquals(trainer.name,"TrainerOne")
    assertEquals(trainer.life,100)
    assertEquals(trainer.defense,50)
    assertEquals(trainer.weight,32.5)
    assertEquals(trainer.profession,"Paladin")
    assertEquals(trainer.mana,0)
    assertEquals(magictrainer.name,"TrainerTwo")
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
}
