package weapon

import exceptions.Require
import unit.{DummyCharacter, ICharacter}

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
 * @version 1.0.3
 */
class Bow(val name:String,
          val damage:Int,
          val weight:Double,
          protected var owner:ICharacter) extends AbstractCommonWeapon {

  def removeOwner(): Unit = { owner = new DummyCharacter }

  def canEquipTo(who: ICharacter): Boolean = {
    if(owner.profession != null) false
    else if(who.profession.name == "Warrior" || who.profession.name == "Ninja" || who.profession.name == "White Mage") true
    else false
  }
}
