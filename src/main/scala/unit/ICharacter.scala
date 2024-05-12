package unit
import profession.Profession
import weapon.Weapon

/** Trait mainly used for type in constructors.
 * Also provides a profession to the character.
 * Used by [[unit.AbstractCharacter]]
 */
trait ICharacter extends Units{
  val profession:Profession

  /** Updates the maxActionbar to the correct value */
  def updateMaxActionbar() : Unit
  def getHeldWeapon : Weapon
  /** Method that calls hurtByCharacter on target enemy;
   * Can't attack and enemy if no weapon is held
   * @param who The enemy to attack
   * */
  def attackAnEnemy(who:Enemy) : Unit
  /** Method that handles taking damage from enemy attack
   * @param who The Enemy attacking the character
   * */
  def hurtByEnemy(who:Enemy) : Unit
}
