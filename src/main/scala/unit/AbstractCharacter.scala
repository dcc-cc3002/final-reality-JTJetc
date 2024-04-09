package unit

import weapon.Weapon

abstract class AbstractCharacter extends ICharacter {
  var heldweapon: Weapon = _

  def isAlive: Boolean = {
    if (life > 0) true
    else false
  }

}
