/*==========================================================================
 |   Source code:  FastFibSequence.java
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


public class FastFibSequence implements Sequence{

   private final int BASE_VALUE = 0;
   private int currentValue;
   private int calculateValues[];// = new int[1];

   FastFibSequence(){
      currentValue = BASE_VALUE;
   }

   public int getCurrent(){
      return currentValue;
   }

   public void setCurrent(int value){
      currentValue = value;
   }

   public void setArrSize(int size){
      calculateValues = new int[size];
   }

   private int fibCalc(int number){
      if(number <= 1)
         return 1;
      else{
         if(calculateValues[number - 1] != 0)
            return calculateValues[number - 1];
         else{
            int x = fibCalc(number - 1) + fibCalc(number - 2);
            calculateValues[number - 1] = x;
            return x;
         }
      }
   }

   public int next(){
      return fibCalc(currentValue);
   }

}
