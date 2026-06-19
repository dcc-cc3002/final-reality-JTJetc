package weapon

/** Exception when trying to equip an invalid weapon to a character.
 *
 * In this case the corresponding professions can equip:
 *
 * - Paladin: Sword and Axe
 *
 * - Warrior: Sword, Axe and Bow
 *
 * - Ninja: Sword, Bow and Wand
 *
 * - Black Mage: Sword, Wand and Staff
 *
 * - White Mage: Bow, Wand and Staff
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.0
 */
class InvalidWeaponException(string : String) extends Exception(string) {

}
