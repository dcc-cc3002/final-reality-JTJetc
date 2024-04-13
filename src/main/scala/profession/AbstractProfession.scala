package profession

/** Abstract class representing professions.
 *
 * Professions name must be provided by the subclasses.
 *
 * Used by [[profession.Warrior]], [[profession.Paladin]], [[profession.Ninja]], [[profession.BlackMage]], and [[profession.WhiteMage]]
 *
 * @param name The name of the profession.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.0
 */
class AbstractProfession(val name:String) extends Profession {
}
