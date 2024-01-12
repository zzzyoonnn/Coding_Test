package programmers.level0;
// 접미사인지 확인하기
import java.util.Scanner;

public class Page3_13 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String my_string = sc.next();
    String is_suffix = sc.next();

    System.out.println(my_string.endsWith(is_suffix) ? 1 : 0);
  }
}
