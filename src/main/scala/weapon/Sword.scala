package weapon

import unit.ICharacter

/** Class representing a Sword.
 *
 * When initializing, owner can be a [[unit.DummyCharacter]]
 *
 * @param name The name of the weapon.
 * @param damage The damage of the weapon.
 * @param weight The weight of the weapon.
 * @param owner The owner of the weapon.
 *
 * @constructor Creates a new Sword.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.1
 */
class Sword(val name:String,
            val damage:Int,
            val weight:Double,
            protected var owner:ICharacter) extends AbstractCommonWeapon {

}
