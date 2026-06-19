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
  val MemberWhiteMage1 : MagicCharacter = new MagicCharacter("Jeff",150,5,45.75,WhiteMage,525)
  val MemberBlackMage1 : MagicCharacter = new MagicCharacter("Smith",175,7,50,BlackMage,250)
  val StarterParty : Party = new Party(MemberWarrior1,MemberBlackMage1,MemberNinja1)
  val SecondParty : Party = new Party(MemberWarrior1,MemberWhiteMage1,MemberPaladin1)

  val StarterSword : Sword = new Sword("Wooden Sword",15,3,new DummyCharacter)
  val StarterAxe : Axe = new Axe("Wooden Axe",18,4,new DummyCharacter)
  val StarterBow : Bow = new Bow("Wooden Bow",12,2,new DummyCharacter)
  val StarterStaff : Staff = new Staff("Wooden Staff",15,3,new DummyCharacter,10)
  val StarterWand : Wand = new Wand("Wooden Wand",10,2,new DummyCharacter,15)
  val StarterWeaponsList : ArrayBuffer[Weapon] = ArrayBuffer[Weapon](StarterSword, StarterAxe, StarterBow, StarterStaff, StarterWand)
  val StrongSword : Sword = new Sword("Excalibur",125,20,new DummyCharacter)
  val StrongAxe : Axe = new Axe("The Axe",150,27.5,new DummyCharacter)
  val StrongBow : Bow = new Bow("Storm Bow",110,17.5,new DummyCharacter)
  val StrongStaff : Staff = new Staff("Spectral Staff",100,25,new DummyCharacter,100)
  val StrongWand : Wand = new Wand("Wand of Truth",25,22.5,new DummyCharacter,125)
  val MoreWeaponsList : ArrayBuffer[Weapon] = ArrayBuffer[Weapon](StarterSword, StarterAxe, StarterBow, StarterStaff, StarterWand, StrongSword, StrongAxe, StrongBow, StrongStaff, StrongWand)

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
  val StrongEnemy1 : Enemy = new EnemyClass("Foo Leader",2500,100,50,150)
  val StrongEnemy2 : Enemy = new EnemyClass("Left Foo Cultist",1000,10,75,80)
  val StrongEnemy3 : Enemy = new EnemyClass("Right Foo Cultist",1000,10,75,80)
  val StrongEnemy4 : Enemy = new EnemyClass("Left Foo Cultist Archer",1000,50,50,87.5)
  val StrongEnemy5 : Enemy = new EnemyClass("Right Foo Cultist Archer",1000,50,50,87.5)
  val StrongEnemies : ListBuffer[Enemy] = ListBuffer[Enemy](StrongEnemy1,StrongEnemy2,StrongEnemy3,StrongEnemy4,StrongEnemy5)

  /** Method called by Main to run the game */
  def run(): Unit = {
    val controller: GameController = new GameController(new Programmer(StarterParty,StarterEnemies),StarterWeaponsList,DarkSpellsList,LightSpellsList)
    while (!controller.battleEnd()) {
      controller.progressGame()
    }

    MemberWarrior1.heal() // healing party leader
    MemberWarrior1.heal()
    MemberWarrior1.heal()
    MemberWarrior1.heal()
    MemberWarrior1.removeWeapon() // un equipping weapons
    MemberBlackMage1.removeWeapon()
    MemberNinja1.removeWeapon()
    println()

    val controller2: GameController = new GameController(new Programmer(SecondParty,StrongEnemies),MoreWeaponsList,DarkSpellsList,LightSpellsList)
    while (!controller2.battleEnd()) {
      controller2.progressGame()
    }
  }
}