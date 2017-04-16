/*==========================================================================
 |   Source code:  Sequence.java
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
 |  Description:  Interface to be implemented by the other classes.
 |                Contains one method, next.
 |
 |        Input:  No input is used.
 |
 |       Output:  No output will be generated.
 |
 |      Process:  Creates a next() method to be used by any class that
 |                will inplement a unique sequence of integers
 |
 |
 |
 |   Required Features Not Included: All required features are included.
 |
 |
 |   Known Bugs: None; the program operates as intended.
 |  *======================================================================*/

public interface Sequence {

   /**
   * Will be used by any class that requires a unique sequence of integers
   * to be generated.
   * @return an integer representation of the current number in the sequence
   */
   int next();
}
