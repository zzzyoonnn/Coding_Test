package programmers.level0;
// 문자열 곱하기
import java.util.Scanner;

public class Page2_01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String my_string = sc.next();
    int k = sc.nextInt();


    for (int i = 0; i < k; i++) {
      System.out.print(my_string);
    }
  }
}
