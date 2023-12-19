package programmers.level0;
// 공배수
import java.util.Scanner;

public class Page2_05 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int n = sc.nextInt();
    int m = sc.nextInt();

    if (num % n == 0 && num % m == 0) {
      System.out.println(1);
    }
    else System.out.println(0);
  }
}
