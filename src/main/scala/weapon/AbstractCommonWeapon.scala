package weapon

import exceptions.Require

/** Abstract class representing non magic weapons.
 *
 * Used by [[weapon.Axe]], [[weapon.Bow]], and [[weapon.Sword]]
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.0
 */
abstract class AbstractCommonWeapon extends Weapon{
  Require.Stat(damage,"damage") atLeast 0
  require(weight>0,"number must be greater than zero")
}
