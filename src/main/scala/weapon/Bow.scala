package weapon

import unit.ICharacter

/** Class representing a Bow.
 *
 * When initializing, owner can be a [[unit.DummyCharacter]]
 *
 * @param name The name of the weapon.
 * @param damage The damage of the weapon.
 * @param weight The weight of the weapon.
 * @param owner The owner of the weapon.
 *
 * @constructor Creates a new Bow.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.0
 */
class Bow(val name:String,val damage:Int,val weight:Double,var owner:ICharacter) extends AbstractCommonWeapon {

}
