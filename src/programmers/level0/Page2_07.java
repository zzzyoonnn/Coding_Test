package programmers.level0;
// 조건 문자열
import java.util.Scanner;

public class Page2_07 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String ineq = sc.next();
    String eq = sc.next();
    int n = sc.nextInt();
    int m = sc.nextInt();

    if (ineq.equals(">")) {
      if (eq.equals("=")) {
        if (n >= m) System.out.println(1);
        else System.out.println(0);
      } else {
        if (n > m) System.out.println(1);
        else System.out.println(0);
      }
    } else if (ineq.equals("<")) {
      if (eq.equals("=")) {
        if (n <= m) System.out.println(1);
        else System.out.println(0);
      } else {
        if (n < m) System.out.println(1);
        else System.out.println(0);
      }
    }
  }
}
