package weapon

import unit.ICharacter

class Wand(val name:String, val damage:Int, val weight:Double, var owner:ICharacter, magic_damage:Int) extends AbstractMagicWeapon(magic_damage) {

}
