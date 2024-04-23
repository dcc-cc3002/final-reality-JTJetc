package weapon

import unit.ICharacter

/** Class representing a Wand.
 *
 * When initializing, owner can be a [[unit.DummyCharacter]]
 *
 * @param name The name of the weapon.
 * @param damage The damage of the weapon.
 * @param weight The weight of the weapon.
 * @param owner The owner of the weapon.
 * @param magic_damage The magic damage of the weapon.
 *
 * @constructor Creates a new Wand.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.0
 */
class Wand(val name:String, val damage:Int, val weight:Double, var owner:ICharacter, magic_damage:Int) extends AbstractMagicWeapon(magic_damage) {

}
