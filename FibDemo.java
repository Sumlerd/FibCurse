/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibcurse;

/**
 *
 * @author Dylan
 */
public class FibDemo {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      FibSequence poppo = new FibSequence(2);
      
      for(int i = 0; i < 10; i++){
         int q = poppo.next();
         System.out.println("fib(" + i + ") = " + q);
      }
   }
   
}
