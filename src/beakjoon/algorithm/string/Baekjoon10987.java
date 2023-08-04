package beakjoon.algorithm.string;
/*
문제
- 알파벳 소문자로만 이루어진 단어가 주어진다. 
  이때, 모음(a, e, i, o, u)의 개수를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 단어가 주어진다. 
  단어의 길이는 1보다 크거나 같고, 100보다 작거나 같으며, 알파벳 소문자로만 이루어져 있다.
출력
- 첫째 줄에 모음의 개수를 출력한다.
ex 1)
입력          출력
- baekjoon    - 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10987 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' )
        count++;
    }

    System.out.println(count);
  }
}
