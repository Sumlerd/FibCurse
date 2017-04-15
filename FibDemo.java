/*==========================================================================
 |   Source code:  FibDemo.java
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
 |   Required Features Not Included:   All required features are included.
 |
 |
 |   Known Bugs:  None; the program operates as intended.
 |  *======================================================================*/

import java.io.File;       //To retrieve input file
import java.io.FileNotFoundException;  //handle exceptin
import java.io.PrintWriter;            //Handle file output
import java.util.Scanner;              //Retrieve file contents

public class FibDemo {

   /**
   *  @param args the command line arguments
   */
   public static void main(String[] args) throws FileNotFoundException {

      Scanner scanIn = new Scanner(new File(args[0]));
      PrintWriter printIn = new PrintWriter(args[1]);

      generateSequence(scanIn, printIn);

      scanIn.close();
      printIn.close();

   }

   /**
    * Generates the fibonacci sequence up to the number
    * provided by arguments[1].
    * @param arguments the command line arguments provided by the user
    * @return fibArray the fibonacci number sequence.
    */
   public static void generateSequence(Scanner in, PrintWriter out){
      int size = in.nextInt();//Integer.parseInt(arguments[0]);
      int i;
      int fibArray[] = new int[size];
      FibSequence fib = new FibSequence();
      LoopFibSequence fib2 = new LoopFibSequence();
      FastFibSequence fib3 = new FastFibSequence();


      long startTime = System.nanoTime();
      for(i = 0; i < size; i++){
         fibArray[i] = fib.next();
         fib.setCurrent(fib.getCurrent() + 1);
      }
      long elapsed = System.nanoTime() - startTime;
      out.println("Recursive Fibonacci Sequence up to " + size + " numbers");
      generateTable(fibArray, out);
      out.println("Generated in " + elapsed + " nanoseconds.");

      out.println();
      out.println();

      fibArray = new int[size];
      startTime = System.nanoTime();
      for(i = 0; i < size; i++){
         fibArray[i] = fib2.next();
         fib2.setCurrent(fib2.getCurrent() + 1);
      }
      elapsed = System.nanoTime() - startTime;
      out.println("Iterative Expected sequence values up to " + size + " numbers");
      generateTable(fibArray, out);
      out.println("Generated in " + elapsed + " nanoseconds.");

      out.println();
      out.println();

      fib3.setArrSize(size);
      fibArray = new int[size];
      startTime = System.nanoTime();
      for(i = 0; i < size; i++){
         fibArray[i] = fib3.next();
         fib3.setCurrent(fib3.getCurrent() + 1);
      }
      elapsed = System.nanoTime() - startTime;
      out.println("Fast sequence values up to " + size + " numbers");
      generateTable(fibArray, out);
      out.println("Generated in " + elapsed + " nanoseconds.");





   }

   /**
    * Generates a table representation of the prime sequence array created
    * using the generateSequence method.
    * Determines if a table will look square or irregular and calls the
    * appropriate method.
    * @param fibArray the fibonacci number sequence
    */
   public static void generateTable(int fibArray[], PrintWriter out){
      int size = fibArray.length;
      int root = (int)Math.sqrt(size);
	   int square = root * root;

      //if the table can be representd as a perfect square
	   if(square == size){
         perfectSquareTable(root, fibArray, out);
      }
      else{
         int remainder = size - square;
         irregularTable(root, remainder, fibArray, out);
      }
      out.println();
      out.println();
   }

   /**
    * Generates a table at that looks as square as possible
    * @param root the size used for the rows/columns of the table
    * @param fibArray the fibonacci number sequence
    */
   public static void perfectSquareTable(int root, int fibArray[], PrintWriter out){

      int i, j;
      int k = 0; //used to keep track of the index of the sequence array

      for(i = 0; i < root; i++){
            out.println();
            for(j = 0; j < root; j++){
               out.printf("%9d%1s", fibArray[k], " ");
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
   public static void irregularTable(int root, int remainder,
      int fibArray[], PrintWriter out){
      int i, j;
      int k = 0; //used to keep track of the index of the sequnce array
      int excess = 0;  //number of elements in excess row to be printed

	   if(root > 10){
         excess = root - 10;
         root = 10;
      }
      out.println();
      if(remainder > 10){
            for(i = 0; i < (remainder % 10); i++){
               out.printf("%9d%1s", fibArray[i], " ");
            }
            for(i = 0; i < (remainder/10); i++){
               out.println();
               for(j = 0; j < 10; j++){
                  out.printf("%9d%1s", fibArray[k + remainder % 10],
                     " ");
                  k++;
               }
            }
         }
		   else{
            for(i = 0; i < remainder; i++){
               out.printf("%9d%1s", fibArray[i], " ");
            }
		   }

         if(remainder == 1)
            k++;
         else
            k+= remainder;

         for(i = 0; i < (root + excess); i++){
            out.println();
            for(j = 0; j < root; j++){
               out.printf("%9d%1s", fibArray[k], " ");
               k++;
            }
         }
   }

}
