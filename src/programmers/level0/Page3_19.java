package programmers.level0;
// 문자 개수 세기
import java.util.Arrays;
import java.util.Scanner;

public class Page3_19 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String my_string = sc.next();
    int[] answer = new int[52];

    for (int i = 0; i < my_string.length(); i++) {
      char c = my_string.charAt(i);
      if (c >= 'A' && c <= 'Z') answer[c - 'A']++;
      else if (c >= 'a' && c <= 'z') answer[c - 'a' + 26]++;
    }

    System.out.println(Arrays.toString(answer));
  }
}
