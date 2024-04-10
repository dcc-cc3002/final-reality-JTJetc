package weapon

import unit.ICharacter

class Sword(val name:String,val damage:Int,val weight:Double,var owner:ICharacter) extends AbstractCommonWeapon {

}
