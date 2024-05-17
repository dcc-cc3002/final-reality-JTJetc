package weapon

import profession._
import unit.{Character, DummyCharacter, MagicCharacter}

class WeaponTest extends munit.FunSuite {
  var TestSword: Sword = new Sword("Starter Sword",5,10,new DummyCharacter)
  var TestAxe: Axe = new Axe("Starter Axe",15,30.5,new DummyCharacter)
  var TestBow: Bow = new Bow("Starter Bow",10,8.25,new DummyCharacter)
  var TestWand: Wand = new Wand("Starter Wand",5,3,new DummyCharacter,20)
  var TestStaff: Staff = new Staff("Starter Staff",10,17.5,new DummyCharacter,15)

  var dude1 = new Character("Dude 1", 100, 50, 32.5, new Paladin)
  var dude2 = new Character("Dude 2", 100, 50, 32.5, new Warrior)
  var dude3 = new Character("Dude 3", 100, 50, 32.5, new Ninja)
  var magic_dude1 = new MagicCharacter("Magic Dude 1", 20, 5, 25, new BlackMage, 1000)
  var magic_dude2 = new MagicCharacter("Magic Dude 2", 20, 5, 25, new WhiteMage, 1000)

  test("Weapons Constructors Tests"){
    assertEquals(TestSword.weight,10.0)
    assertEquals(TestStaff.magic_damage,15)
  }
  test("Equipping weapons Tests"){
    assertEquals(dude1.getHeldWeapon,null) //No held weapons
    assertEquals(dude2.getHeldWeapon,null)
    assertEquals(dude3.getHeldWeapon,null)
    assertEquals(magic_dude1.getHeldWeapon,null)
    assertEquals(magic_dude2.getHeldWeapon,null)
    assertEquals(TestSword.getOwner,null) //DummyCharacters or rather no owners
    assertEquals(TestAxe.getOwner,null)
    assertEquals(TestBow.getOwner,null)
    assertEquals(TestWand.getOwner,null)
    assertEquals(TestStaff.getOwner,null)
    //canEquipWeapon?
    //equipWeapon
  }
}
