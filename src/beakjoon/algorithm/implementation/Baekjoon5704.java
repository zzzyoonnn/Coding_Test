package beakjoon.algorithm.implementation;
/*
문제
- 팬그램은 알파벳의 모든 글자들을 사용해서 만든 문장이다. 
  "the quick brown fox jumps over a lazy dog"과 "jackdaws loves my big sphinx of quartz"은 팬그램이다. 
  문장이 주어졌을 때, 팬그램인지 아닌지를 알아내는 프로그램을 작성하시오.
입력
- 입력은 여러 테스트 케이스로 이루어져 있다. 
  각 테스트 케이스는 많아야 200글자로 이루어져 있는 문장이다. 
  단어는 공백 하나로 구분되어 있다. 
  또, 단어는 알파벳 소문자로만 이루어져 있다. 
  입력의 마지막 줄에는 별표(*)가 하나 주어진다.
출력
- 각 테스트 케이스에 대해서, 입력으로 주어진 문장이 팬그램이라면 'Y', 아니라면 'N'를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon5704 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<Character> set = new HashSet<>();

    while (true) {
      String s = br.readLine();

      if (s.equals("*")) break;

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c == ' ') continue;

        if (!set.contains(c)) set.add(c);
      }

      if (set.size() == 26) System.out.println("Y");
      else System.out.println("N");

      set.clear();
    }
  }
}
