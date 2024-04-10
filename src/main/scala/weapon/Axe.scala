package weapon

import unit.ICharacter

class Axe(val name:String,val damage:Int,val weight:Double,var owner:ICharacter) extends AbstractCommonWeapon {

}
