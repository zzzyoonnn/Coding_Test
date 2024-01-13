package programmers.level0;
// 문자열 뒤집기
import java.util.Scanner;

public class Page3_16 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String my_string = sc.next();
    int s = sc.nextInt();
    int e = sc.nextInt();

    StringBuilder sb = new StringBuilder(my_string);
    StringBuilder reverse = new StringBuilder(my_string.substring(s, e + 1));
    reverse = reverse.reverse();

    sb.replace(s, e + 1, reverse.toString());
    System.out.println(sb);

  }
}
