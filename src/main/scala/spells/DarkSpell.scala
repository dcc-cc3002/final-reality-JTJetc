package spells

import unit.{Enemy, MagicAlly}
import weapon.MagicWeapon

/** Trait for BlackMage related spells */
trait DarkSpell {
  /** Name of the spell */
  val name : String
  /** The method to cast the spell */
  def castSpell(owner:MagicAlly,md:Int,target:Enemy) : Unit
}
