package programmers.level0;
// 문자열의 뒤의 n글자
import java.util.Scanner;

public class Page3_11 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String my_string = sc.next();
    int n = sc.nextInt();

    my_string = my_string.substring(my_string.length() - n);

    System.out.println(my_string);
  }
}
