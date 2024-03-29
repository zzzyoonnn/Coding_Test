package programmers.level1;
import java.util.Scanner;

public class Hambuger {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    boolean[] alphabet = new boolean[26];
    int[] answer = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      if (alphabet[s.charAt(i) - 'a'] == false) {
        answer[i] = -1;
        alphabet[s.charAt(i) - 'a'] = true;
      }
      else {
        for (int j = 0; j < i; j++) {
          if (s.charAt(j) == s.charAt(i)) answer[i] = i - j;
        }
      }
    }

    for (int i : answer) System.out.println(i);
  }
}
