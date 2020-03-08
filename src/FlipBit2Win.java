public class FlipBit2Win {

  static int flipToWin(int a){

    if(~a==0) return Integer.SIZE;

    int current = 0, previous = 0, maxLen = 1;
    int lastBit = 0;
    while(a != 0){


      if ((a & 1)== 1){
          current++;
        lastBit = 1;
      } else if((a&1) ==0){

        if(lastBit==0){
          previous = 0;
        } else {
          previous = current;
        }

        lastBit = 0;

        current = 0;
      }
      maxLen = Math.max(previous + current + 1, maxLen);
      a >>>= 1;


    }

    return maxLen;

  }


  public static void main(String[] args) {
    int a = 0b11011101111;
    System.out.println(Integer.toBinaryString(a) + " max = " + flipToWin(a));

    a = 0b111011101100;
    System.out.println(Integer.toBinaryString(a) + " max = " + flipToWin(a));
  }
}
