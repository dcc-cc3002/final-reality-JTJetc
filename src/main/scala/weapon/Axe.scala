package weapon

import exceptions.Require
import unit.{DummyCharacter, ICharacter}

/** Class representing an Axe.
 *
 * When initializing, owner can be a [[unit.DummyCharacter]]
 *
 * @param name The name of the weapon.
 * @param damage The damage of the weapon.
 * @param weight The weight of the weapon.
 * @param owner The owner of the weapon.
 *
 * @constructor Creates a new Axe.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.3
 */
class Axe(val name:String,
          val damage:Int,
          val weight:Double,
          protected var owner:ICharacter) extends AbstractCommonWeapon {


  def canEquipTo(who: ICharacter): Boolean = {
    if(owner.profession != null) false
    else if(who.profession.name == "Paladin" || who.profession.name == "Warrior") true
    else false
  }

}
