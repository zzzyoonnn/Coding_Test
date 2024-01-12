package programmers.level0;
// 접두사인지 확인하기
import java.util.Scanner;

public class Page3_15 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String my_string = sc.next();
    String is_prefix = sc.next();

    System.out.println(my_string.startsWith(is_prefix) ? 1 : 0);
  }
}
