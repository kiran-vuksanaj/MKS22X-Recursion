import java.util.ArrayList;

public class NQueen{
  public static void main(String[] args){
    for(int i=0;i<20;i++){
      System.out.println(i+": "+NQueen(i));
    }
  }


  public static int NQueen(int n){
    ArrayList<Integer> colVals = new ArrayList<Integer>();
    return nqHelper(n,colVals);
  }
  private static int nqHelper(int n,ArrayList<Integer> colVals){
    if(n==colVals.size()) return 1;
    int out = 0;
    for(int i=0;i<n;i++){
      if(!(underAttack(i,colVals))){
        colVals.add(i);
        out += nqHelper(n,colVals);
        colVals.remove(colVals.size()-1);
      }
    }
    return out;
  }
  private static boolean underAttack(int col,ArrayList<Integer> colVals){
    int row = colVals.size();
    for(int rowInd = 0; rowInd<colVals.size(); rowInd++){
      if(conflictBetween(row,col,rowInd,colVals.get(rowInd))) return true;
    }
    return false;
  }
  private static boolean conflictBetween(int row1,int col1,int row2,int col2){
    return row1==row2 || col1==col2 ||
           Math.abs(row2-row1) == Math.abs(col2-col1);
  }
}
