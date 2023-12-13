package programmers.level0;
// [PCCE 기출문제] 5번 / 산책
import java.util.Arrays;
import java.util.Scanner;

public class Page1_05 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String route = sc.next();
    int east = 0;
    int north = 0;
    int[] answer = new int[2];
    for (int i = 0; i < route.length(); i++) {
      switch(route.charAt(i)) {
        case 'N':
          north++;
          break;
        case 'S':
          north--;
          break;
        case 'E':
          east++;
          break;
        case 'W':
          east--;
          break;
      }
    }
    answer[0] = east;
    answer[1] = north;
    System.out.print(Arrays.toString(answer));
  }
}
