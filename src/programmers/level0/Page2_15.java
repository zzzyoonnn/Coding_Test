package programmers.level0;
// 수 조작하기 1
import java.util.Scanner;

public class Page2_15 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String s = sc.next();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'w') n++;
      else if (s.charAt(i) == 's') n--;
      else if (s.charAt(i) == 'd') n += 10;
      else if (s.charAt(i) == 'a') n -= 10;
    }

    System.out.println(n);
  }
}
