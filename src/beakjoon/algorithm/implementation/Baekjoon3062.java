package beakjoon.algorithm.implementation;
/*
문제
- 수 124를 뒤집으면 421이 되고 이 두 수를 합하면 545가 된다. 
  124와 같이 원래 수와 뒤집은 수를 합한 수가 좌우 대칭이 되는지 테스트 하는 프로그램을 작성하시오.
입력
- 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
  각 테스트 케이스는 한 줄에 하나의 정수 N(10 ≤ N ≤ 100000)이 주어진다.
출력
- 각 테스트 케이스에 대해서 원래 수와 뒤집은 수를 합한 수가 좌우 대칭이 되면 YES를 아니면 NO를 한 줄에 하나씩 출력한다.
ex 1)
입력      출력
- 4       - YES
  13        NO
  58        YES
  120       NO
  5056
 */
import java.util.Scanner;

public class Baekjoon3062 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    String s;
    StringBuilder sb;
    String sbstr;
    int n = sc.nextInt();
    boolean check = true;

    for (int i = 0; i < n; i++) {
      s = sc.next();
      sb = new StringBuilder(s);
      sb = sb.reverse();
      sbstr = sb.toString();

      int a = Integer.parseInt(s);
      int b = Integer.parseInt(sbstr);

      int sum = a + b;
      String sumstr = Integer.toString(sum);

      check = true;
      for (int j = 0; j < sumstr.length() / 2; j++) {
        if (sumstr.charAt(j) == sumstr.charAt(sumstr.length() - j - 1)) continue;
        else {
          check = false;
          break;
        }
      }
      if (check) System.out.println("YES");
      else System.out.println("NO");
    }
  }
}
