import java.util.ArrayList;

public class recursion{
  /*You may write additional private methods */

  /*Recursively find the sqrt using Newton's approximation
   *tolerance is the allowed percent error the squared answer is away from n.
   *precondition: n is non-negative

  */
  public static double sqrt(double n, double tolerance){
    //helper method with an extra parameter, a guess that is continuously refined
    return sqrtGuess(n,tolerance,1);
  }
  private static double sqrtGuess(double n,double tol,double guess){
    if(percentError(n,guess) < tol){
      return guess;
    }else{
      return 0;
    }
  }
  private static double percentError(double actual,double experimental){
    return Math.abs((experimental - actual) / actual) * 100;
  }

  /*Recursively find the n'th fibbonaci number in linear time
   *fib(0) = 1; fib(1) = 1; fib(5) = 5
   *precondition: n is non-negative
   */
  public static int fib(int n){
    return 0;
  }

  /*As Per classwork*/
  public static ArrayList<Integer> makeAllSums(){
    return null;
  }
}
