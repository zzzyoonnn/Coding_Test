package programmers.level0;
// 문자열의 앞의 n글자
import java.util.Scanner;

public class Page3_14 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String my_string = sc.next();
    int n = sc.nextInt();

    System.out.println(my_string.substring(0, n));
  }
}
