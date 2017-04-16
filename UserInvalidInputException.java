/*==========================================================================
 |   Source code:  UserInvalidInputException.java
 |        Author:  Dylan Sumler
 |    Student ID:  3538998
 |    Assignment:  Assignment #6 - Fibonacci calculator
 |
 |        Course:  COP 3337 (Programming II)
 |       Section:  U02
 |    Instructor:  William Feild
 |      Due Date:  20 April 2017, class time
 |
 |	I hereby certify that this collective work is my own
 |	and none of it is the work of any other person or entity.
 |	______________________________________ [Signature]
 |
 |      Language:  Java
 |   Compile/Run:
 |
 |
 |  +-----------------------------------------------------------------------
 |
 |  Description:
 |
 |        Input:
 |
 |       Output:
 |
 |      Process:
 |
 |
 |
 |   Required Features Not Included: All required features are included.
 |
 |
 |   Known Bugs: None; the program operates as intended.
 |  *======================================================================*/

public class UserInvalidInputException extends IllegalArgumentException{

   UserInvalidInputException(){}

   UserInvalidInputException(String message){
      super(message);
   }

}
