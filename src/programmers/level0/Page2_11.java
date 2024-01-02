package programmers.level0;
// 주사위 게임 2
import java.util.Scanner;

public class Page2_11 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int answer = 0;

    if (a == b && a == c && b == c) {   // 세 수가 모두 같다면
      answer = (a + b + c) * ((a * a) + (b * b) + (c * c)) * ((a * a * a) + (b * b * b) + (c * c * c));
    } else if (a != b && a != c && b != c) {    // 세 수가 모두 다르다면
      answer = a + b + c;
    } else {    // 세 숫자 중 두 숫자가 같다면
      answer = (a + b + c) * ((a * a) + (b * b) + (c * c));
    }

    System.out.println(answer);
  }
}
