package weapon

import exceptions.Require
import unit.ICharacter

/** Abstract class representing magic weapons.
 *
 * Used by [[weapon.Staff]], and [[weapon.Wand]]
 *
 * @param magic_damage The magic damage of the weapon.
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.1
 */
abstract class AbstractMagicWeapon(val magic_damage: Int) extends Weapon{
Require.Stat(magic_damage,"Magic damage") atLeast 0

  def getOwner : ICharacter = {
    if(owner.profession == null) null
    else owner
  }
}
