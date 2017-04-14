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

package fibcurse;

/**
 *
 * @author Dylan
 */
public class FibSequence implements Sequence{
   
   private final int FIRST_NUMBER = 0; //lowest possbile value of the sequence
   private int currentValue;        //current value in the sequence
   
   FibSequence(){
      currentValue = 1;
   }
   
   FibSequence(int SequenceValue){
      currentValue = SequenceValue;
   }
   
   public int getCurrent(){
      return currentValue;
   }
   
   public void setCurrent(int value){
      currentValue = value;
   }
   
   private int fibCalc(int number){
      return fibCalc(number - 1) + fibCalc(number - 2);
   }
   
   
   @Override
   public int next(){
      if(currentValue <= 1)
         return 1;
      else{
         return fibCalc(currentValue);    
      }
   } 
   
}
