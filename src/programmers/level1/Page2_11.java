package programmers.level1;
// 3진법 뒤집기
import java.util.Scanner;

public class Page2_11 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String answer = "";

    while (n != 0) {
      answer += n % 3;
      n /= 3;
    }

    System.out.println(Integer.parseInt(answer, 3));

  }
}
