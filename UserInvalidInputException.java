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
 |   Compile/Run:  javac Sequence.java FibSequence.java LoopFibSequence.java
 |                 FastFibSequence.java UserInvalidInputException.java
 |                 FibDemo.java
 |                 java FibDemo inputFile.txt outputFile.txt

 |                 Paths to inputFile.txt and outputFile.txt must be absolute.
 |                 Open outputFile.txt to observe output.
 |                 Output was tested using Notepad on Windows 7 OS, proper
 |                 output display is not guaranteed for any other text editors.
 |
 |
 |  +-----------------------------------------------------------------------
 |
 |  Description:  This class is used to handle exceptions dealing with
 |                user input. It should be thrown whenever invalid
 |                user input is detected such as invalid types or
 |                values outside of a pre-defined range.
 |
 |        Input:  No input will be used for this class.
 |
 |       Output:  No output will be generated by this class.
 |
 |      Process:  When this exception is thrown, a message defined by
 |                the developer will displayed.
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
