import java.util.ArrayList;

public class recursion{
  /*You may write additional private methods */
  public static void main(String[] args){
    System.out.println("\t///SQRT");
    System.out.println("sqrt(10) = "+sqrt(10,0.0001));
    System.out.println("sqrt(10)[low precision] = "+sqrt(10,100));
    System.out.println("sqrt(100) = "+sqrt(100,0.0001));
    System.out.println("sqrt(0) = "+sqrt(0,0.0001));
    System.out.println("sqrt(0.0001) = "+sqrt(0.0001,0.0001));
    System.out.println("\t///FIB");
    System.out.println("fib(0) = "+fib(0));
    System.out.println("fib(1) = "+fib(1));
    System.out.println("fib(2) = "+fib(2));
    System.out.println("fib(3) = "+fib(3));
    System.out.println("fib(10) = "+fib(10));
    System.out.println("fib(45) = "+fib(45));
    System.out.println("\t///MAKEALLSUMS");
    System.out.println("MAS(0): "+makeAllSums(0));
    System.out.println("MAS(1): "+makeAllSums(1));
    System.out.println("MAS(2): "+makeAllSums(2));
    System.out.println("MAS(3): "+makeAllSums(3));
    System.out.println("MAS(7): "+makeAllSums(7));
  }
  /*Recursively find the sqrt using Newton's approximation
   *tolerance is the allowed percent error the squared answer is away from n.
   *precondition: n is non-negative

  */
  public static double sqrt(double n, double tolerance){
    //helper method with an extra parameter, a guess that is continuously refined
    if(n==0) return 0; //special case to avoid division by zero
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
    return fibStoredVals(n,1,0,0);
  }
  private static int fibStoredVals(int endInd,int prevVal,int curVal,int curInd){
    if(curInd == endInd){
      //when proper term has been generated, exit recursive loop
      return curVal;
    }else{
      //otherwise, generate the new term and call the method again with new as current, current as previous, and incremented index
      int newVal = prevVal + curVal;
      return fibStoredVals(endInd,curVal,newVal,curInd+1);
    }
  }
  /*As Per classwork*/
  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> out = new ArrayList<Integer>();
    makeSumsRecurs(n,0,out);
    return out;
  }
  private static void makeSumsRecurs(int n,int total,ArrayList<Integer> out){
    if(n==0){
      //when the method has traced down to the bottom of the tree; return total accumulated over each step
      out.add(total);
    }else{
      //two method calls, each with n-1 to step down in the tree, and one increasing the total by n(those including n) and the other not changing the total
      makeSumsRecurs(n-1,total+n,out);
      makeSumsRecurs(n-1,total  ,out);
    }
  }
}
