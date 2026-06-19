package weapon

import unit.DummyCharacter

class WeaponTest extends munit.FunSuite {
  var TestSword: Sword = new Sword("Starter Sword",5,10,new DummyCharacter)
  var TestAxe: Axe = new Axe("Starter Axe",15,30.5,new DummyCharacter)
  var TestBow: Bow = new Bow("Starter Bow",10,8.25,new DummyCharacter)
  var TestWand: Wand = new Wand("Starter Wand",5,3,new DummyCharacter,20)
  var TestStaff: Staff = new Staff("Starter Staff",10,17.5,new DummyCharacter,15)

  test("Weapons Constructors Tests"){
    assertEquals(TestSword.weight,10.0)
    assertEquals(TestStaff.magic_damage,15)
  }
}
