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
 |  Description:  This class tests the functionality of the sequence classes
 |                (FastFib, Fib, and LoopFib), by generating a
 |                Fibonacci sequence of numbers based on file input provided
 |                by the user. Three tables will be generated, illustrating
 |                the output and execution time of the three sequences.
 |                The ouput will sent to a file provided by the user.
 |
 |        Input:  The file containing the number of Fibonacci values to be
 |                generated.
 |
 |       Output:  The file where the tables will be written to.
 |
 |      Process:  The user will input the absolute paths to two files in
 |                the command line when executing the program. The first
 |                file will be read from to determine the size of the tables
 |                and the second file will be written to. Three sequences
 |                will be generated and the time required to generate them
 |                will be recored and appended at the bottom of each table.
 |                The user can open the file uses as the second command
 |                line argument to view the output.
 |                Additionally, the input file will be checked to ensure
 |                existence and valid contents.
 |
 |   Required Features Not Included:   All required features are included.
 |
 |
 |   Known Bugs:  None; the program operates as intended.
 |  *======================================================================*/

import java.io.File;                   //To retrieve input file
import java.io.FileNotFoundException;  //Handle filenotfound exception
import java.io.PrintWriter;            //Handle file output
import java.util.Scanner;              //Retrieve file contents

public class FibDemo {

   /**
   *  Checks the arguments to ensure the appropriate amount has been
   *  provided and runs the program.
   *  @param args the command line arguments
   */
   public static void main(String[] args) throws
   ArrayIndexOutOfBoundsException, FileNotFoundException{
      try{
         checkArgs(args);
      }
      catch(ArrayIndexOutOfBoundsException exception){
         System.out.println("Please enter two arguments; the first being "
            + "the input file and the second being the output file.");
      }
   }

   /**
   *  Generates three fibonacci sequences up to the number
   *  provided by in and generates three tables in the file associated with out.
   *  @param in The Scanner associated with the input file.
   *  @param out The PrintWriter associated with the output file.
   */
   public static void generateSequence(Scanner in, PrintWriter out){
      int size = in.nextInt();
      int i;
      int fibArray[] = new int[size];
      FibSequence fib1 = new FibSequence();
      LoopFibSequence fib2 = new LoopFibSequence();
      FastFibSequence fib3 = new FastFibSequence();

      formatOutput(fib1, fibArray, out);
      formatOutput(fib2, fibArray, out);
      formatOutput(fib3, fibArray, out);
   }

   /**
   *  Detemines the fibonacci sequence using a recursive algorithm and
   *  creates a table.
   *  @param fib The regular recursive fibonacci sequence object.
   *  @param fibArray The empty array that will store the generated sequence.
   *  @param out  The PrintWriter associated with the output file.
   */
   public static void formatOutput(FibSequence fib, int[] fibArray,
      PrintWriter out){

         int i;
         int size = fibArray.length;
         long startTime = System.nanoTime();
         for(i = 0; i < size; i++){
            fibArray[i] = fib.next();
            fib.setCurrent(fib.getCurrent() + 1);
         }
         long elapsed = System.nanoTime() - startTime;
         out.println("Recursive Fibonacci Sequence up to " + size + " numbers");
         generateTable(fibArray, out);
         out.println("Generated in " + elapsed + " nanoseconds.");
         out.println("______________________________________________________"
            + "__");
         out.println();
   }

   /**
   *  Detemines the fibonacci sequence using an iterative algorithm and
   *  creates a table.
   *  @param fib The iterative recursive fibonacci sequence object.
   *  @param fibArray The empty array that will store the generated sequence.
   *  @param out  The PrintWriter associated with the output file.
   */
   public static void formatOutput(LoopFibSequence fib, int[] fibArray,
      PrintWriter out){

         int i;
         int size = fibArray.length;
         long startTime = System.nanoTime();
         for(i = 0; i < size; i++){
            fibArray[i] = fib.next();
            fib.setCurrent(fib.getCurrent() + 1);
         }
         long elapsed = System.nanoTime() - startTime;
         out.println("Iterative expected sequence values up to " + size +
            " numbers");
         generateTable(fibArray, out);
         out.println("Generated in " + elapsed + " nanoseconds.");
         out.println("______________________________________________________"
            + "__");
         out.println();
   }

   /**
   *  Detemines the fibonacci sequence using a fast recursive algorithm and
   *  creates a table.
   *  @param fib The fast recursive fibonacci sequence object.
   *  @param fibArray The empty array that will store the generated sequence.
   *  @param out  The PrintWriter associated with the output file.
   */
   public static void formatOutput(FastFibSequence fib, int[] fibArray,
      PrintWriter out){

         int i;
         int size = fibArray.length;
         fib.setArrSize(size);
         long startTime = System.nanoTime();
         for(i = 0; i < size; i++){
            fibArray[i] = fib.next();
            fib.setCurrent(fib.getCurrent() + 1);
         }
         long elapsed = System.nanoTime() - startTime;
         out.println("Fast sequence values up to " + size + " numbers");
         generateTable(fibArray, out);
         out.println("Generated in " + elapsed + " nanoseconds.");
         out.println();
   }

   /**
   *  Generates a table representation of the Fibonacci sequence array created
   *  using the generateSequence method.
   *  Determines if a table will look square or irregular and calls the
   *  appropriate method.
   *  @param fibArray The fibonacci number sequence.
   *  @param out The PrintWriter associated with the file to be written to.
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
   *  Generates a table at that looks as square as possible.
   *  @param root The size used for the rows/columns of the table.
   *  @param fibArray The fibonacci number sequence.
   *  @param out The PrintWriter associated with the file to be written to.
   */
   public static void perfectSquareTable(int root, int fibArray[],
      PrintWriter out){

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
   *  Generates a table that attempts to look as square as possible.
   *  @param root the size used for the rows/columns of the table.
   *  @param remainder the elements placed in the excess row.
   *  @param fibArray the fibonacci number sequence.
   *  @param out The PrintWriter associted with the file to be written to.
   */
   public static void irregularTable(int root, int remainder,
      int fibArray[], PrintWriter out){

         int i, j;
         int k = 0; //used to keep track of the index of the sequnce array

         for(i = 0; i < root; i++){
               out.println();
               for(j = 0; j < root; j++){
                  out.printf("%9d%1s", fibArray[k], " ");
                  k++;
               }
               if(remainder > 0){
                  if(remainder >= root){
                     remainder--;
                     out.printf("%9d%1s", fibArray[k], " ");
                     k++;
                  }
                  else if(remainder / 2 != 0){
                     remainder--;
                     out.printf("%9d%1s", fibArray[k], " ");
                     k++;
                  }
                  remainder--;
                  out.printf("%9d%1s", fibArray[k], " ");
                  k++;
               }
         }
   }

   /**
   *  Check the user input to ensure that the input file exists.
   *  @param args Array containing input and output file arguments.
   */
   public static void checkArgs(String args[]) throws FileNotFoundException{

      PrintWriter printIn = new PrintWriter(args[1]);

      try{
         Scanner scanIn = new Scanner(new File(args[0]));
         try{
            checkFile(scanIn);
            /*To deal with intermediate NoSuchElementException*/
            scanIn = new Scanner(new File(args[0]));
            generateSequence(scanIn, printIn);
         }
         finally{
            scanIn.close();
            printIn.close();
         }
      }
      catch(FileNotFoundException exception){
         File wrongFile = new File(args[0]);
         System.out.println("File at " + wrongFile.getAbsolutePath() +
            " does not exist.");
      }

   }

   /**
   *  Check file input to insure that the contents are valid.
   *  @param in Scanner object containing file contents.
   */
   public static void checkFile(Scanner in) throws UserInvalidInputException{
      if(!in.hasNext())
         throw new UserInvalidInputException("Input file is empty.");
      else if(!in.hasNextInt())
         throw new UserInvalidInputException("Value in input file is not " +
            "not an integer.");
      else{
         int value = in.nextInt();
         if(value < 1)
            throw new UserInvalidInputException("Positive non-zero value " +
               "in input file expected.");
         else if(value > 39)
            throw new UserInvalidInputException("Value in input file greater" +
            " than maximum allowed value (39).");
      }
   }
}
