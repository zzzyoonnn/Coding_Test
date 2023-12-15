package programmers.level0;
// 대소문자 바꿔서 출력하기
import java.util.Scanner;

public class Page1_12 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (Character.isUpperCase(s.charAt(i))) sb.append(Character.toLowerCase(s.charAt(i)));
      else sb.append(Character.toUpperCase(s.charAt(i)));
    }

    System.out.println(sb);
  }
}
