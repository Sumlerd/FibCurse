/*==========================================================================
 |   Source code:  FibSequence.java
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
 |   Required Features Not Included:
 |
 |
 |   Known Bugs:
 |  *======================================================================*/


/**
 *
 * @author Dylan
 */
public class FibSequence implements Sequence{

   private final int BASE_VALUE = 0; //lowest possbile value of the sequence
   private int currentValue;        //current value in the sequence

   /**
   *  The default constructor of the fibonacci sequence. Sets the starting
   *  index to one.
   */
   FibSequence(){
      currentValue = BASE_VALUE;
   }

   /**
   *  Constructor to start the fibonacci sequence as a specific index
   */
   FibSequence(int SequenceValue){
      currentValue = SequenceValue;
   }

   /**
   *  Gets the current index of the fibonacci sequence
   */
   public int getCurrent(){
      return currentValue;
   }

   /**
   *  Sets the index of the current fibonacci sequence
   */
   public void setCurrent(int value){
      currentValue = value;
   }

   /**
   *  Calculates the next number in the Fibonacci sequence.
   */
   private int fibCalc(int number){
      if(number <= 1)
         return 1;
      else
         return fibCalc(number - 1) + fibCalc(number - 2);
   }

   /**
   * implements the next method of the sequence class.
   */
   @Override
   public int next(){
      return fibCalc(currentValue);
   }

}
