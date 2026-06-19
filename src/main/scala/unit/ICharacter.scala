package unit
import profession.Profession

/** Trait mainly used for type in constructors.
 * Also provides a profession to the character.
 * Used by [[unit.AbstractCharacter]]
 */
trait ICharacter extends Units{
  val profession:Profession
}
