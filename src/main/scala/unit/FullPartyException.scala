package unit

/** Exception when trying to add a member to a full party. (max of 3 members)
 *
 * @author Javier Torres
 * @since 1.0.0
 * @version 1.0.0
 */
class FullPartyException(string : String) extends Exception(string){

}
