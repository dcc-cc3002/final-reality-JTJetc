package weapon

/** Exception when trying to equip a weapon, when it's already being used by someone else
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.0
 */
class UsedWeaponException(string : String) extends Exception(string){

}
