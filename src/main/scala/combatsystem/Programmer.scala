package combatsystem
import unit.{Enemy, IParty}
import scala.collection.mutable.ListBuffer

class Programmer(var party: IParty,
                 val enemies: ListBuffer[Enemy]) {
 var k : Int = 3
}