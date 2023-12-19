package programmers.level0;
// n의 배수
import java.util.Scanner;

public class Page2_04 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int n = sc.nextInt();

    if (num % n == 0) System.out.println(1);
    else System.out.println(0);
  }
}
