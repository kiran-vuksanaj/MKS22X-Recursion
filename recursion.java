import java.util.ArrayList;

public class recursion{
  /*You may write additional private methods */
  public static void main(String[] args){
    System.out.println("\t///SQRT");
    System.out.println("sqrt(10) = "+sqrt(10,0.0001));
    System.out.println("sqrt(100) = "+sqrt(100,0.0001));
    //System.out.println("sqrt(0) = "+sqrt(0,0.0001));
    System.out.println("sqrt(0.0001) = "+sqrt(0.0001,0.0001));
  }
  /*Recursively find the sqrt using Newton's approximation
   *tolerance is the allowed percent error the squared answer is away from n.
   *precondition: n is non-negative

  */
  public static double sqrt(double n, double tolerance){
    //helper method with an extra parameter, a guess that is continuously refined
    return sqrtGuess(n,tolerance,1);
  }
  private static double sqrtGuess(double n,double tol,double guess){
    //System.out.println(guess);
    //System.out.println(percentError(n,guess*guess));
    if(percentError(n,guess*guess) < tol){
      //guess is good enough, exit recursive loop
      return guess;
    }else{
      //guess is still too far off, new recursive call with recalculated guess
      double newGuess = (n / guess + guess) / 2;
      return sqrtGuess(n,tol,newGuess);
    }
  }
  private static double percentError(double actual,double experimental){
    return Math.abs( (experimental - actual) / actual) * 100;
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
