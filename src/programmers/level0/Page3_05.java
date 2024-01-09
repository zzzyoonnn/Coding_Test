package programmers.level0;
// 주사위 게임 3
import java.util.Scanner;

public class Page3_05 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();

    int answer = 0;

    if (a == b && a == c && a == d) answer = 1111 * a;
    else if (a == b && a == c) answer = (10 * a + d) * (10 * a + d);
    else if (a == b && a == d) answer = (10 * a + c) * (10 * a + c);
    else if (a == c && a == d) answer = (10 * a + b) * (10 * a + b);
    else if (b == c && b == d) answer = (10 * b + a) * (10 * b + a);
    else if (a == b && c == d) answer = (a + c) * Math.abs(a - c);
    else if (a == b && c != d) answer = c * d;
    else if (a == c && b == d) answer = (a + b) * Math.abs(a - b);
    else if (a == c && b != d) answer = b * d;
    else if (a == d && b == c) answer = (a + b) * Math.abs(a - b);
    else if (a == d && b != c) answer = b * c;
    else if (b == c && a == d) answer = (b + a) * Math.abs(b - a);
    else if (b == c && a != d) answer = a * d;
    else if (b == d && a == c) answer = (b + a) * Math.abs(b - a);
    else if (b == d && a != c) answer = a * c;
    else if (c == d && a == b) answer = (c + a) * Math.abs(c - a);
    else if (c == d && a == b) answer = a * b;
    else answer = Math.min(a, Math.min(b, Math.min(c, d)));

    System.out.println(answer);
  }
}
