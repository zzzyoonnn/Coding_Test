package programmers.level1;
// 크기가 작은 부분문자열
import java.util.Scanner;

public class Page2_15 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String t = sc.next();
    String p = sc.next();

    int tl = t.length();
    int pl = p.length();

    int answer = 0;
    for (int i = 0; i < tl - pl + 1; i++) {
      if (Long.parseLong(t.substring(i, i + pl)) <= Long.parseLong(p)) answer++;
    }
    System.out.println(answer);
  }
}
