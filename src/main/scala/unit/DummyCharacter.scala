package unit

/** Class representing a special case Character
 *
 * This Dummy is used for empty party members, and also initializing weapons to have no owner.
 * Methods implemented here should make it easier by not checking if there is a real character present.
 *
 * Extends from [[unit.Character]], with null profession to check empty members in party.
 *
 * @example isAlive method always returns false, ideal for checking party status with any empty party members.
 * @constructor Creates a new Dummy.
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.0
 */
class DummyCharacter extends Character(profession = null) {
  life = 0
}
