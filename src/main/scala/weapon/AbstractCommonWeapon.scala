package weapon

import exceptions.Require
import unit.{DummyCharacter, ICharacter}

/** Abstract class representing non magic weapons.
 *
 * Used by [[weapon.Axe]], [[weapon.Bow]], and [[weapon.Sword]]
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.1
 */
abstract class AbstractCommonWeapon extends Weapon{
  Require.Stat(damage,"damage") atLeast 0
  require(weight>0,"number must be greater than zero")

  def getOwner : ICharacter = {
    if(owner.profession == null) null
    else owner
  }
  def removeOwner(): Unit = { owner = new DummyCharacter }
  def equipTo(who: ICharacter): Unit = {
    if(owner.profession != null) throw new UsedWeaponException(s"$name is already being used by someone else")
    else if(!canEquipTo(who)) throw new InvalidWeaponException(s"Can not equip ${this.getClass.getName} to ${who.profession.name}")
    else { owner = who }
  }
}
