package weapon

import unit.{DummyCharacter, ICharacter}

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
 * @version 1.0.3
 */
class Wand(val name:String,
           val damage:Int,
           val weight:Double,
           protected var owner:ICharacter,
           magic_damage:Int) extends AbstractMagicWeapon(magic_damage) {

  def removeOwner(): Unit = { owner = new DummyCharacter }

  def canEquipTo(who: ICharacter): Boolean = {
    if(owner.profession != null) false
    else if(who.profession.name == "Ninja" || who.profession.name == "Black Mage" || who.profession.name == "White Mage") true
    else false
  }
}
