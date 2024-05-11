# Final Reality

>Final Reality is a simplified clone of the renowned game, Final Fantasy. Its main purpose is to
serve as an educational tool, teaching foundational programming concepts.

*This README is yours to complete it. Take this opportunity to describe your contributions, the
design decisions you've made, and any other information you deem necessary.*

## 1° Assigment
### Partial Assigment 1
- Made sure to not use words "Unit", "Class", "def" for naming, to avoid problems with existing 
fields, instead used "Units", "Profession", and "defense".
- Packages/folders for Weapons, Professions, and Units which correspond to Characters and Enemies.
- Units trait for common stats between enemies and player characters.
- ICharacter trait adds profession field and Enemy trait adds damage.
- Abstract class for empty held weapon and isAlive method, common in all characters.
- Party class, with default dummy characters, can ask members if they are alive to determine if whole party 
is alive, and can add members up to three.
- Profession trait with name implemented by each profession extending from abstract class 
constructor, which will be easier to compare later.
- Weapon trait for common attributes, and two abstract classes for common and magic weapons with magic damage.
- Tests with munit.FunSuite, mainly of constructors, making sure to have good coverage.
### Partial Assigment 2
- Programmer class in charge to manage actionbar changes and determining which enemy or character can get a turn
- Programmer can add and remove units (max 3 party members, max 5 enemies per battle)
- Programmer for now has an arbitrary amount k to increase the actionbar each step
- They ideal combat manager will step the programmer, then ask if any member can perform a turn, and if true,
perform an action with returned unit, otherwise keep stepping to increase actionbars
- Maybe one programmer object can be used for each different battle, making sure to destroy the leftover object
### Final Assigment
- Started the privatization of values and methods, making sure that var type values where at least protected, while
val types can be public. And added methods to view some now private or protected values.
- Decided to add a maxLife value for units, it could be useful in the future for not healing over the maximum.
- Used require to avoid using illegal values in constructors.
- 

This project is licensed under the
[Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).