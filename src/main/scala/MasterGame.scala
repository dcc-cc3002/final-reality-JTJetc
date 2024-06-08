import combatsystem.{Programmer,GameController}
import profession._
import spells._
import unit._
import weapon._
import scala.collection.mutable.ListBuffer

/** In development class that contains game flow */
class MasterGame { // Main should create this and run it

  //init
  val Warrior : Profession = new Warrior
  val Paladin : Profession = new Paladin
  val Ninja : Profession = new Ninja
  val WhiteMage : Profession = new WhiteMage
  val BlackMage : Profession = new BlackMage

  val MemberWarrior1 : Character = new Character("John",250,5,70,Warrior)
  val MemberPaladin1 : Character = new Character("Yim",500,10,90,Paladin)
  val MemberNinja1 : Character = new Character("???",150,7,55.5,Ninja)
  val MemberWhiteMage1 : MagicCharacter = new MagicCharacter("Jeff",150,5,45.75,WhiteMage,250)
  val MemberBlackMage1 : MagicCharacter = new MagicCharacter("Smith",175,7,50,BlackMage,200)
  val StarterParty : Party = new Party(MemberWarrior1,MemberBlackMage1)

  val StarterSword : Sword = new Sword("Wooden Sword",15,3,new DummyCharacter)
  val StarterAxe : Axe = new Axe("Wooden Axe",18,4,new DummyCharacter)
  val StarterBow : Bow = new Bow("Wooden Bow",12,2,new DummyCharacter)
  val StarterStaff : Staff = new Staff("Wooden Staff",15,3,new DummyCharacter,10)
  val StarterWand : Staff = new Staff("Wooden Wand",10,2,new DummyCharacter,15)

  val Fire : DarkSpell = new Fire
  val Thunder : DarkSpell = new Thunder
  val Paralysis : LightSpell = new Paralysis
  val Poison : LightSpell = new Poison
  val Heal : LightSpell = new Heal

  val StarterEnemy1 : Enemy = new EnemyClass("Foo Follower",50,10,5,65.0)
  val StarterEnemy2 : Enemy = new EnemyClass("Foo Follower",40,10,4,52.5)
  val StarterEnemy3 : Enemy = new EnemyClass("Foo Follower",30,10,3,40.0)
  val StarterEnemies : ListBuffer[Enemy] = ListBuffer[Enemy](StarterEnemy1,StarterEnemy2,StarterEnemy3)

  /** In development run method */
  def run(): Unit = {
    val controller: GameController = new GameController(new Programmer(StarterParty,StarterEnemies))
    /*while (!controller.hasFinished()) { //tentative approach
      controller.handleInput()
      controller.update()
    }*/
  }
}