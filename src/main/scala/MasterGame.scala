import combatsystem.{GameController, Programmer}
import profession._
import spells._
import unit._
import weapon._

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/** Class in charge of the game flow.
 *
 * Handles creating needed aspects for battles and calls methods from the [[GameController]] for the game to run.
 * @author Javier Torres
 * @since 1.1
 * @version 1.1 */
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
  val StarterParty : Party = new Party(MemberWarrior1,MemberBlackMage1,MemberNinja1)
  val SecondParty : Party = new Party(MemberWarrior1,MemberWhiteMage1,MemberPaladin1)

  val StarterSword : Sword = new Sword("Wooden Sword",15,3,new DummyCharacter)
  val StarterAxe : Axe = new Axe("Wooden Axe",18,4,new DummyCharacter)
  val StarterBow : Bow = new Bow("Wooden Bow",12,2,new DummyCharacter)
  val StarterStaff : Staff = new Staff("Wooden Staff",15,3,new DummyCharacter,10)
  val StarterWand : Wand = new Wand("Wooden Wand",10,2,new DummyCharacter,15)
  val StarterWeaponsList : ArrayBuffer[Weapon] = ArrayBuffer[Weapon](StarterSword, StarterAxe, StarterBow, StarterStaff, StarterWand)

  val Fire : DarkSpell = new Fire
  val Thunder : DarkSpell = new Thunder
  val Paralysis : LightSpell = new Paralysis
  val Poison : LightSpell = new Poison
  val Heal : LightSpell = new Heal
  val DarkSpellsList : ArrayBuffer[DarkSpell] = ArrayBuffer[DarkSpell](Fire, Thunder)
  val LightSpellsList : ArrayBuffer[LightSpell] = ArrayBuffer[LightSpell](Paralysis,Poison,Heal)

  val StarterEnemy1 : Enemy = new EnemyClass("Foo Follower Top",50,10,5,65.0)
  val StarterEnemy2 : Enemy = new EnemyClass("Foo Follower Mid",40,10,4,52.5)
  val StarterEnemy3 : Enemy = new EnemyClass("Foo Follower Low",30,10,3,40.0)
  val StarterEnemies : ListBuffer[Enemy] = ListBuffer[Enemy](StarterEnemy1,StarterEnemy2,StarterEnemy3)

  /** Method called by Main to run the game */
  def run(): Unit = {
    val controller: GameController = new GameController(new Programmer(StarterParty,StarterEnemies),StarterWeaponsList,DarkSpellsList,LightSpellsList)
    while (!controller.battleEnd()) {
      controller.progressGame()
    }
  }
}