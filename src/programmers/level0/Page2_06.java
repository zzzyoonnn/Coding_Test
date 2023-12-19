package programmers.level0;
// 홀짝에 따라 다른 값 반환하기
import java.util.Scanner;

public class Page2_06 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int answer = 0;

    if (n % 2 == 1) {
      for (int i = 1; i <= n; i += 2) answer += i;
    } else {
      for (int i = 2; i <= n; i += 2) answer += (i * i);
    }
    System.out.println(answer);
  }
}
