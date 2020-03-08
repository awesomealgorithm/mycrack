import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation0808 {


  public static List<String> getPerm(String text){

    List<String> stringList = new ArrayList<>();

    getPerm(stringList, "", text);
    return stringList;

  }

  public static Set<String> getPermBottomUp(String text){

    var stringList = new HashSet<String>();


    for( char c : text.toCharArray()){
      if(stringList.size() == 0){
        stringList.add(String.valueOf(c));
        continue;
      }
      var newList = new HashSet<String>();
      for(String item : stringList){

        for(int j= 0; j <= item.length(); j++){
          var prefix = item.subSequence(0, j);
          var suffix = item.substring(j);
          newList.add(prefix + String.valueOf(c) + suffix);
        }
      }
      stringList = newList;

    }

    return stringList;

  }


  public static Set<String> getPermSet(String text){

    Set<String> permutationSet = new HashSet<>();

    getPermSet(permutationSet, "", text);
    return permutationSet;

  }

  private static void getPermSet(Set<String> permutationSet, String pre, String reminder){
    if (reminder.length()==0){
      permutationSet.add(pre);
      return;
    }


    for(int i=0; i < reminder.length(); i++){

      var c = reminder.charAt(i);
      var prefix = reminder.subSequence(0, i);
      var suffix = reminder.substring(i+1);

      getPermSet(permutationSet, pre+c, prefix+suffix);
    }
  }

  private static void getPerm(List<String> permutationSet, String pre, String reminder){
    if (reminder.length()==0){
      permutationSet.add(pre);
      return;
    }

    byte flag = 0;
    for(int i=0; i < reminder.length(); i++){

      var c = reminder.charAt(i);
      if( (flag & 1<<c) !=0) continue;
      flag |= 1<<c;
      var prefix = reminder.subSequence(0, i);
      var suffix = reminder.substring(i+1);

      getPerm(permutationSet, pre+c, prefix+suffix);
    }
  }

  public static void main(String[] args) {

//    List<String> results = getPerm("abcc");
//    Set<String> expected = getPermSet("abcc");
//    System.out.println(results.size() == expected.size());
//    expected.addAll(results);
//    System.out.println(results.size() == expected.size());

    Set<String> results = getPermBottomUp("abcdd");
    System.out.println(results);
    Set<String> expected = getPermSet("abcdd");
    System.out.println(results.size() == expected.size());
    expected.addAll(results);
    System.out.println(results.size() == expected.size());
  }
}
