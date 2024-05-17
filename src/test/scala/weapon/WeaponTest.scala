package weapon

import profession._
import unit.{Character, DummyCharacter, MagicCharacter}

class WeaponTest extends munit.FunSuite {
  var TestSword: Sword = _
  var TestAxe: Axe = _
  var TestBow: Bow = _
  var TestWand: Wand = _
  var TestStaff: Staff = _

  var dude1 : Character = _
  var dude2 : Character = _
  var dude3 : Character = _
  var magic_dude1 : MagicCharacter = _
  var magic_dude2 : MagicCharacter = _
  override def beforeEach(context: BeforeEach): Unit = {
    TestSword = new Sword("Starter Sword",5,10,new DummyCharacter)
    TestAxe = new Axe("Starter Axe",15,30.5,new DummyCharacter)
    TestBow = new Bow("Starter Bow",10,8.25,new DummyCharacter)
    TestWand = new Wand("Starter Wand",5,3,new DummyCharacter,20)
    TestStaff = new Staff("Starter Staff",10,17.5,new DummyCharacter,15)

    dude1 = new Character("Dude 1", 100, 50, 32.5, new Paladin)
    dude2 = new Character("Dude 2", 100, 50, 32.5, new Warrior)
    dude3 = new Character("Dude 3", 100, 50, 32.5, new Ninja)
    magic_dude1 = new MagicCharacter("Magic Dude 1", 20, 5, 25, new BlackMage, 1000)
    magic_dude2 = new MagicCharacter("Magic Dude 2", 20, 5, 25, new WhiteMage, 1000)
  }
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

    assertEquals(dude1.canEquipWeapon(TestSword),true)
    assertEquals(dude1.canEquipWeapon(TestBow),false)
    dude1.equipWeapon(TestSword)
    dude2.equipWeapon(TestAxe)
    dude3.equipWeapon(TestBow)
    magic_dude1.equipWeapon(TestWand)
    magic_dude2.equipWeapon(TestStaff)

    assertEquals(TestSword.getOwner,dude1)
    assertEquals(TestAxe.getOwner,dude2)
    assertEquals(TestBow.getOwner,dude3)
    assertEquals(TestWand.getOwner,magic_dude1)
    assertEquals(TestStaff.getOwner,magic_dude2)
    assertEquals(dude1.getHeldWeapon,TestSword)
    assertEquals(dude2.getHeldWeapon,TestAxe)
    assertEquals(dude3.getHeldWeapon,TestBow)
    assertEquals(magic_dude1.getHeldWeapon,TestWand)
    assertEquals(magic_dude2.getHeldWeapon,TestStaff)

    assertEquals(dude1.canEquipWeapon(TestSword),false) //weapon is now being used
    assertEquals(dude1.canEquipWeapon(null),false)
  }
  test("Equipping weapons exceptions"){
    interceptMessage[InvalidWeaponException]("Can not equip magic weapon.Staff to Paladin"){dude1.equipWeapon(TestStaff)}
    dude1.equipWeapon(TestAxe)
    interceptMessage[UsedWeaponException]("Starter Axe is already being used by someone else"){dude2.equipWeapon(TestAxe)}
    intercept[NullPointerException](dude1.equipWeapon(null))
  }

  test("More Coverage"){
    magic_dude1.equipWeapon(TestWand)
    magic_dude1.removeWeapon()
    assertEquals(magic_dude1.getHeldWeapon,null)
    assertEquals(dude1.canEquipWeapon(TestWand),false)
    assertEquals(magic_dude1.canEquipWeapon(TestAxe),false)
    assertEquals(magic_dude2.canEquipWeapon(TestSword),false)
  }
}
