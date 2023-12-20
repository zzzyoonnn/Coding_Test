package programmers.level0;
// flag에 따라 다른 값 반환하기
import java.util.Scanner;

public class Page2_08 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    String flag = sc.next();

    if (flag.equals("true")) System.out.println(a + b);
    else System.out.println(a - b);
  }
}
