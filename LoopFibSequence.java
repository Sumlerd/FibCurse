/*==========================================================================
 |   Source code:  LoopFibSequence.java
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

public class LoopFibSequence implements Sequence{

   private final int BASE_VALUE = 0;   //Lowest possible value in the sequence
   private int currentValue;

   LoopFibSequence(){
      currentValue = BASE_VALUE;
   }

   public int getCurrent(){
      return currentValue;
   }

   public void setCurrent(int value){
      currentValue = value;
   }

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

   @Override
   public int next(){
      return fibCalc(currentValue);
   }

}
