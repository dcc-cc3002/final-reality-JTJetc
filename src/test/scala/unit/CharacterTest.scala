package unit

class CharacterTest extends munit.FunSuite {
  var trainer: Character = _
  var magictrainer: Character = _

  override def beforeEach(context: BeforeEach): Unit = {
    trainer = new Character("TrainerOne",100,50,32.5,"Paladin")
    magictrainer = new Character("TrainerTwo",20,5,25,"BlackMage",1000)
  }
  test("Character constructor checks"){
    assertEquals(trainer.name,"TrainerOne")
    assertEquals(trainer.life,100)
    assertEquals(trainer.defense,50)
    assertEquals(trainer.weight,32.5)
    assertEquals(trainer.profession,"Paladin")
    assertEquals(magictrainer.name,"TrainerTwo")
    assertEquals(magictrainer.life,20)
    assertEquals(magictrainer.defense,5)
    assertEquals(magictrainer.weight,25)
    assertEquals(magictrainer.profession,"BlackMage")
    assertEquals(magictrainer.mana,1000)
  }
}
