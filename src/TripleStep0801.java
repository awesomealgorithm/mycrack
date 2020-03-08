import java.util.Arrays;

public class TripleStep0801 {

  private static int[] mem = new int[10];

  public static  int allStepCaseCount(int current , int totalSteps){

    if(current > totalSteps) return 0;

    if(current == totalSteps) return 1;

    if (mem[current] != 0) return mem[current];
    int total = allStepCaseCount(current+1, totalSteps) + allStepCaseCount(current+2, totalSteps) + allStepCaseCount(current+3, totalSteps);

      mem[current] = total;
      return total;




  }



  public static void main(String[] args) {

    System.out.println(allStepCaseCount(0, 4));//7
    // 1 1 1 1
    // 2 1 1
    // 1 2 1
    // 1 1 2
    // 1 3
    // 3 1
    // 2 2
    System.out.println(Arrays.toString(mem));

  }
}
