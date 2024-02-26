package beakjoon.algorithm.implementation;
/*
문제
- 끝말잇기는 단어를 중복하지 않고 단어의 맨 끝 글자에 이어서 말하는 놀이입니다. 
  끝말잇기 기록은 단어들의 나열로 이루어집니다. 
  올바른 끝말잇기 기록은 각 단어의 마지막 글자가 다음 단어의 첫 글자이며, 단어가 중복되어서 나타나면 안 됩니다.
  끝말잇기 기록이 주어지는데, 하나의 기록은 “?”로 가려진 채로 들어옵니다. 
  “?”에 들어갈 수 있는 문자열들의 후보가 주어질 때, 올바른 끝말잇기 기록을 만드는 “?”에 들어갈 문자열을 출력하세요.
입력
- 첫 줄에 끝말잇기 기록의 길이 N 이 주어집니다. (1 <= N <= 100) 
  둘째 줄부터 다음 N개의 줄에는 끝말잇기의 기록 S1, ... , SN이 한 줄에 하나씩 주어집니다. 
  여기서, 하나의 Si는 “?” 로 주어집니다. 
  나머지 Si는 길이 2 이상 10 이하의 영어 소문자로 이루어진 문자열입니다.
  다음 줄에 후보 단어의 개수 M이 주어집니다. (1 <= M <= 100) 
  다음 M개의 줄에는 후보 단어 A1, ... , AM이 주어집니다. 
  Ai는 길이 2 이상 10 이하의 영어 소문자로 이루어진 문자열입니다. 
  A1, ... , AM은 서로 다릅니다.
  문제의 답이 정확히 하나인 경우만 입력으로 주어집니다.
출력
- “?”에 들어갈 수 있는 문자열을 후보 단어인 A1, ... , AM 중에서 하나 찾아서 출력하세요.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon28432 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    char start = '0';
    char end = '0';
    boolean check = false;

    HashSet<String> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      set.add(word);

      if (word.equals("?")) {
        check = true;
      } else if (check && end == '0') {
        end = word.charAt(0);
      } else if (!check) {
        start = word.charAt(word.length() - 1);
      }
    }

    int m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      String find = br.readLine();

      if (set.contains(find)) continue;

      boolean first = (start == '0' || find.charAt(0) == start);
      boolean last = (end == '0' || find.charAt(find.length() - 1) == end);

      if (first && last) {
        System.out.println(find);
        break;
      }
    }
  }
}
