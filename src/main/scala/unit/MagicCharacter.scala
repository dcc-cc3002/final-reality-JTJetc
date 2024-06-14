package unit

import exceptions.Require
import profession.Profession
import spells.{DarkSpell, InvalidSpellException, LightSpell}
import weapon.MagicWeapon

/** Class representing a Magic Character.
 *
 * When initializing, one can skip the defense value, alternative constructor defaults it to 0.
 *
 * @param name The name of the magic character.
 * @param life The life and maxLife of the magic character.
 * @param defense The defense of the magic character.
 * @param weight The weight of the magic character.
 * @param profession The profession of the magic character.
 * @param mana The mana and maxMana of the magic character.
 *
 * @constructor Creates a new Magic Character.
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.1
 */
class MagicCharacter(val name: String = "Unknown",
                     protected var life: Int = 0,
                     protected var defense: Int = 0,
                     val weight: Double = 0.1,
                     val profession: Profession,
                     private var mana:Int=1) extends AbstractCharacter with MagicAlly{
  /** Alternative constructor if one where to skip defense, defaulting it to 0 */
  def this(x: String, l: Int, w: Double, p: Profession, m: Int) = {
    this(x, l, 0, w, p, m)
  }
  /** Max life value, initialized to the constructor life value */
  val maxLife : Int = life
  /** Max mana value, initialized to the constructor mana value */
  val maxMana : Int = mana
  Require.Stat(life,"life") atLeast 0
  Require.Stat(defense,"defense") atLeast 0
  require(weight>0,"number must be greater than zero")
  Require.Stat(mana,"mana") atLeast 0
  /**The actionbar of the character, starts at zero*/
  private var actionbar : Double = 0
  /**The threshold to complete to consider a complete actionbar and be able to get a turn*/
  private var maxActionbar: Double = {
    if (heldweapon != null) weight + (heldweapon.weight / 2)
    else weight
  }

  def updateMaxActionbar() : Unit = { //make sure when you could equip a weapon, to update maxActionBar
    if (heldweapon != null) maxActionbar = weight + (heldweapon.weight / 2)
    else maxActionbar = weight
  }

  /** Method that compares actionbar with maxActionbar
   *
   * @return The difference between actionbar and maxActionbar, the excess must be greater or equal to zero
   */
  def getActionBar: Double = {
    actionbar - maxActionbar
  }

  /** Method that adds k to character action bar.
   * In case k = 0, actionbar goes back to zero.
   *
   * @param k Amount to change actionbar
   */
  def setActionBar(k: Int): Unit = {
    if(k != 0 && isAlive) actionbar += k
    else actionbar = 0
  }

  def getMana: Int = {
    mana
  }

  def loseMana(n: Int): Unit = {
    mana -= n
  }

  def castSpell(spell:DarkSpell,target:Enemy) : Unit = { //Deal damage and chance of status effect
    if(profession.name != "Black Mage") throw new InvalidSpellException("White Mage can't perform Dark Magic")
    else if(heldweapon == null) throw new InvalidSpellException("Need a magic weapon for casting")
    else if(heldweapon.magic_damage == 0) throw new InvalidSpellException("Need a magic weapon for casting")
    else if(!target.isAlive) throw new InvalidSpellException("Can't cast on death target")
    else spell.castSpell(this,heldweapon.magic_damage,target)
  }
  def castSpell(spell:LightSpell,target:Enemy) : Unit = { //Inflict status effect
    if(profession.name != "White Mage") throw new InvalidSpellException("Black Mage can't perform Light Magic")
    else if(spell.name == "Heal") throw new InvalidSpellException(s"Can't Heal an enemy")
    else if(heldweapon == null) throw new InvalidSpellException("Need a magic weapon for casting spells")
    else if(heldweapon.magic_damage == 0) throw new InvalidSpellException("Need a magic weapon for casting spells")
    else if(!target.isAlive) throw new InvalidSpellException("Can't cast on death target")
    else spell.castSpell(this,heldweapon.magic_damage,target)
  }
  def castSpell(spell:LightSpell,target:ICharacter) : Unit = { //Heal ally
    if(profession.name != "White Mage") throw new InvalidSpellException("Black Mage can't perform Light Magic")
    else if(spell.name != "Heal") throw new InvalidSpellException(s"Can't cast ${spell.name} on ally")
    else if(heldweapon == null) throw new InvalidSpellException("Need a magic weapon for casting heals")
    else if(heldweapon.magic_damage == 0) throw new InvalidSpellException("Need a magic weapon for casting spells")
    else if(!target.isAlive) throw new InvalidSpellException("Can't heal a death ally")
    else spell.castSpell(this,heldweapon.magic_damage,target)
  }

  override def transformThisToMagicAlly() : MagicAlly = { this }
}