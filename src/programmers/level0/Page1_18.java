package programmers.level0;
// 문자열 겹쳐쓰기
import java.util.Scanner;

public class Page1_18 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String my_string = sc.next();
    String overrite_string = sc.next();
    int s = sc.nextInt();

    String start = my_string.substring(0, s);
    String middle = overrite_string;
    String end = my_string.substring(s + overrite_string.length());

    System.out.println(start + middle + end);
  }
}
