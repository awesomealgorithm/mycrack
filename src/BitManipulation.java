public class BitManipulation {

  public static int insert(int m, int n, int i, int j){
    int length = j -i +1;

    int mask = (1 << length+1) - 1  << i;
    m &= ~mask;

    m |= n << i;
    return m;

  }

  public static void main(String[] args) {
    int m = 0b10000000000;
    int n = 0b10011;
    int i = 2, j=6;

    System.out.println(Integer.toBinaryString(insert(m ,n ,i, j)));
  }
}
