package programmers.level1;
// 시저 암호
import java.util.Scanner;

public class Page2_18 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int n = sc.nextInt();

    String answer = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        answer += c;
        continue;
      }

      if (Character.isLowerCase(c)) {
        answer += (char) ((c - 'a' + n) % 26 + 'a');
      } else if (Character.isUpperCase(c)) {
        answer += (char) ((c - 'A' + n) % 26 + 'A');
      }
    }
    System.out.println(answer);
  }
}
