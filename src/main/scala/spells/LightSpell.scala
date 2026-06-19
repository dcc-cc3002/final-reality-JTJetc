package spells

import unit.{MagicAlly, Units}
import weapon.MagicWeapon

/** Trait for WhiteMage related spells */
trait LightSpell {
  /** Name of the spell */
  val name : String
  /** The method to cast the spell */
  def castSpell(owner:MagicAlly,md:Int,target:Units) : Unit

  /** Mana Cost */
  val cost : Int
}
