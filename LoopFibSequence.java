/*==========================================================================
 |   Source code:  LoopFibSequence.java
 |        Author:  Dylan Sumler
 |    Student ID:  3538998
 |    Assignment:  Assignment #6 - Fibonacci sequence
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
 |  +-----------------------------------------------------------------------
 |
 |  Description:  This class implements the next method in the sequence class
 |                and determines the next number in the Fibonacci sequence
 |                iteratively to generate expected values.
 |
 |        Input:  No input is used for this class.
 |
 |       Output:  No output is generated by this class.
 |
 |      Process:  A LoopFibSequence object is created and the next method is
 |                called to generate the next number of the sequence. The next
 |                method calls the fibCalc method which determines the nth
 |                number of the sequence where n is a parameter for fibCalc.
 |
 |   Required Features Not Included:   All required features are included.
 |
 |
 |   Known Bugs:  None; the program operates as intended.
 |  *======================================================================*/

public class LoopFibSequence implements Sequence{

   private int currentValue;        //current value in the sequence

   /**
   *  Default constructor.
   */
   LoopFibSequence(){}

   /**
   *  Gets the current index of the sequence.
   *  @return The current index of the sequence.
   */
   public int getCurrent(){
      return currentValue;
   }

   /**
   *  Sets the current index of the sequence.
   *  @param value The updated index of the sequence.
   */
   public void setCurrent(int value){
      currentValue = value;
   }

   /**
   *  Calculates the next number in the Fibonacci sequence using an
   *  iterative algorithm.
   *  Algorithm created with the assistance of Big Java, 4th ed. pg 571.
   *  @param number The current index of the sequence.
   *  @return The next number in the sequence.
   */
   private int fibCalc(int number){
      if(number <= 1)
         return 1;

      int olderValue = 1;
      int oldValue = 1;
      int newValue = 1;
      int i;

      for(i = 1; i < number; i++){
         newValue = oldValue + olderValue;
         olderValue = oldValue;
         oldValue = newValue;
      }
      return newValue;
   }

   /**
   *  Implements the next method of the sequence interface.
   *  @return The next value of the sequence.
   */
   @Override
   public int next(){
      return fibCalc(currentValue);
   }

}
