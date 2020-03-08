import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet0804 {

  public static List<List<Integer>> getSubSets(List<Integer> set){

    List<List<Integer>> allSubSets = new ArrayList<>();
    allSubSets.add(Collections.emptyList());

    set.forEach( item -> {
      List<List<Integer>> tempSubSets = new ArrayList<>();
      allSubSets.forEach( subSet ->{
        List<Integer> newSet = new ArrayList<>();
        newSet.addAll(subSet);
        newSet.add(item);
        tempSubSets.add(newSet);
      });

      allSubSets.addAll(tempSubSets);
    });

    return  allSubSets;

  }

  public static void main(String[] args) {
    List<List<Integer>> result1= getSubSets(List.of(2,5,6,7));
    result1.forEach( setItem -> {
      System.out.println(setItem.toString());
    });

  }
}
