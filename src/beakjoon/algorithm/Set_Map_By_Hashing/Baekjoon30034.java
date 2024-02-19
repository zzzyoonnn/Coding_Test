package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 문자열을 좋아한 임스는 문자열 관련 새로운 게임을 만들었다.
  문자열을 나누는 기준인 구분자, 구분자에서 제외하는 조건인 병합자와 관련하여 기준을 정하였다.
  새로운 게임의 규칙은 다음과 같다.
  이 게임은 문자열을 규칙에 따라 나누는 게임이다.
    문자열을 공백과 주어진 구분자들로 나눈다.
    각 문자 구분자는 영어 대소문자 중 하나이다.
    각 숫자 구분자는 0부터 9까지의 숫자 중 하나이다.
    병합자로 주어진 문자들은 구분자로 취급하지 않는다.
    각 병합자는 영어 대소문자와 0부터 9까지의 숫자 중 하나이다.
    구분자와 병합자는 모두 한 글자로 이루어져 있다.
    나눌 문자열인 기준 문자열은 영어 대소문자, 숫자, 공백으로 이루어져 있다.
    같은 구분자 및 병합자가 주어질 수 있다.
  N개의 문자 구분자, M개의 숫자 구분자, K개의 병합자, 문자열의 길이 S와 기준 문자열이 주어질 때 해당 규칙들을 적용한 결과를 출력한다.
입력
- 첫 번째 줄에는 문자 구분자의 개수 N이 주어진다. (1 <= N <= 1,000) 
  두 번째 줄에는 N개의 문자 구분자가 공백으로 구분되어 주어진다.
  세 번째 줄에는 숫자 구분자의 개수 M이 주어진다. (1 <= M <= 1,000) 
  네 번째 줄에는 M개의 숫자 구분자가 공백으로 구분되어 주어진다.
  다섯 번째 줄에는 병합자의 개수 K가 주어진다. (1 <= K <= 1,000) 
  여섯 번째 줄에는 K개의 병합자가 공백으로 구분되어 주어진다.
  일곱 번째 줄에는 기준 문자열의 길이 S가 주어진다. (1 <= S <= 1,000) 
  여덟 번째 줄에는 기준 문자열이 주어진다.
출력
- 해당 규칙들을 적용한 결과를 한 줄에 하나씩 출력한다.
  빈 문자열로 결과가 주어지는 경우는 없다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon30034 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashSet<Character> set = new HashSet<>();
    int n = Integer.parseInt(br.readLine());    // 문자 구분자 개수
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      set.add(st.nextToken().charAt(0));
    }

    int m = Integer.parseInt(br.readLine());    // 숫자 구분자 개수
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      set.add(st.nextToken().charAt(0));
    }

    int k = Integer.parseInt(br.readLine());    // 병합자 구분자 개수, 구분자 X
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      char ch = st.nextToken().charAt(0);
      if (set.contains(ch)) {
        set.remove(ch);
      }
    }

    int length = Integer.parseInt(br.readLine());    // 기준 문자열의 길이
    char[] arr = br.readLine().toCharArray();
    StringBuilder sb = new StringBuilder();
    boolean check = false;
    for (char c : arr) {
      if (set.contains(c) || c == ' ') {
        if (check) {
          sb.append('\n');
          check = false;
        }
        continue;
      }
      sb.append(c);
      check = true;
    }
    System.out.println(sb);
  }
}
