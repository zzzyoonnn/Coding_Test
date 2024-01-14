package programmers.level0;
// 세로 읽기
import java.util.Scanner;

public class Page3_17 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String my_string = sc.next();
    int m = sc.nextInt();
    int c = sc.nextInt();

    String answer = "";

    for (int i = 0; i < my_string.length(); i += m) {
      answer += my_string.charAt(i + c - 1);

    }

    System.out.println(answer);
  }
}
