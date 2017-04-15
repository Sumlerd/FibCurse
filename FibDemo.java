/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;     //To calculate execution time

public class FibDemo {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {

      Date date = new Date();
      int fibSequence[] = generateSequence(args);
      generateTable(fibSequence);
      Date date2 = new Date();

      long elapsed = date2.getTime() - date.getTime();

      System.out.println("\nElapsed time in ms: " + elapsed);
   }

   /**
    * Generates the fibonacci sequence up to the number
    * provided by arguments[1].
    * @param arguments the command line arguments provided by the user
    * @return fibArray the fibonacci number sequence.
    */
   public static int[] generateSequence(String arguments[]){
      int size = Integer.parseInt(arguments[0]);
      int i;
      int fibArray[] = new int[size];
      FibSequence fib = new FibSequence();

      for(i = 0; i < size; i++){
         fibArray[i] = fib.next();
         fib.setCurrent(fib.getCurrent() + 1);
      }
      return fibArray;
   }

   /**
    * Generates a table representation of the prime sequence array created
    * using the generateSequence method.
    * Determines if a table will look square or irregular and calls the
    * appropriate method.
    * @param fibArray the fibonacci number sequence
    */
   public static void generateTable(int fibArray[]){
      int size = fibArray.length;
      int root = (int)Math.sqrt(size);
	   int square = root * root;

      //if the table can be representd as a perfect square
	   if(square == size){
         perfectSquareTable(root, fibArray);
      }
      else{
         int remainder = size - square;
         irregularTable(root, remainder, fibArray);
      }
   }

   /**
    * Generates a table at that looks as square as possible
    * @param root the size used for the rows/columns of the table
    * @param fibArray the fibonacci number sequence
    */
   public static void perfectSquareTable(int root, int fibArray[]){

      int i, j;
      int k = 0; //used to keep track of the index of the sequence array

      System.out.println("Fibonacci Sequence Table\n");
      for(i = 0; i < root; i++){
            System.out.println();
            for(j = 0; j < root; j++){
               System.out.format("%9d%1s", fibArray[k], " ");
               k++;
            }
         }
   }

   /**
    * Generates a table that attempts to look as square as possible
    * @param root the size used for the rows/columns of the table
    * @param remainder the elements placed in the excess row
    * @param primeArray the fibonacci number sequence
    */
   public static void irregularTable(int root, int remainder, int fibArray[]){
      int i, j;
      int k = 0; //used to keep track of the index of the sequnce array
      int excess = 0;  //number of elements in excess row to be printed

	  if(root > 10){
         excess = root - 10;
         root = 10;
      }
      System.out.println("Prime Sequence Table\n");
      if(remainder > 10){
            for(i = 0; i < (remainder % 10); i++){
               System.out.format("%9d%1s", fibArray[i], " ");
            }
            for(i = 0; i < (remainder/10); i++){
               System.out.println();
               for(j = 0; j < 10; j++){
                  System.out.format("%9d%1s", fibArray[k + remainder % 10],
                     " ");
                  k++;
               }
            }
         }
		   else{
            for(i = 0; i < remainder; i++){
               System.out.format("%9d%1s", fibArray[i], " ");
            }
		   }

         if(remainder == 1)
            k++;
         else
            k+= remainder;

         for(i = 0; i < (root + excess); i++){
            System.out.println();
            for(j = 0; j < root; j++){
               System.out.format("%9d%1s", fibArray[k], " ");
               k++;
            }
         }
   }

}
