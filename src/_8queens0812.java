import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _8queens0812 {


  public  static List<int[]> findPlacesForQueens(int gridSize){

    List<int[]> allways = new LinkedList<>();
    int[] placed = new int[gridSize];
    int colFlg = 0;
    findPlace(allways, placed, 0,  gridSize, colFlg);


    return allways;
  }
  private static  void findPlace(List<int[]> allWays, int[] placed, int row, int gridSize, int colFlg){
    if(row >= gridSize){
      allWays.add(Arrays.copyOf(placed, gridSize));
      return;
    }


      for(int col =0; col < gridSize; col++){
        if(row == 0 ||   (colFlg & 1<<col) ==0 && isValidPosition(placed, row, col)){
          placed[row] = col;
          findPlace(allWays, placed, row+1,  gridSize, colFlg | 1 << col);
      }

    }


  }
  private static boolean isValidPosition(int[] placed, int row, int col){
    for(int i =0; i < row; i++){
      if( Math.abs(col - placed[i]) == Math.abs(row - i)){
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {

    var result = findPlacesForQueens(8);
    System.out.println(result.size());
  }
}
