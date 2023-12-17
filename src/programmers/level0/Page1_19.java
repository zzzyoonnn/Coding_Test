package programmers.level0;
// 문자열 섞기
import java.util.Scanner;

public class Page1_19 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = sc.next();
    String str2 = sc.next();

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str1.length(); i++) {
      sb.append(str1.charAt(i)).append(str2.charAt(i));
    }
    System.out.println(sb);
  }
}
