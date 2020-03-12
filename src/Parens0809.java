import java.util.ArrayList;
import java.util.List;

public class Parens0809 {


  public static List<String> getAll(int num){

    List<String> combinations = new ArrayList<>();


    int left=0, right=0;

    findMatch(combinations, "", left, right, num);
    return combinations;
  }

  private static void findMatch( List<String> combinations, String prefix, int left, int right, int num){
    if(left > num || right > num || right > left){
      return;
    }
    if(right == num){
      combinations.add(prefix);
      return;
    }

    findMatch(combinations, prefix+"(",  left+1, right, num);
    findMatch(combinations, prefix+")",  left, right+1, num);
  }
  public static void main(String[] args) {

    System.out.println(getAll(3));
  }
}
