package beakjoon.algorithm.implementation;
/*
문제
- 알파벳 대소문자로 구성된 문자열 A가 주어진다. 
  한 개 이상의 알파벳 대문자가 공백으로 구분된 문자 목록 B가 주어진다. 
  문자 목록 B에는 중복된 대문자가 존재하지 않는다. 
  문자 목록 B에 존재하는 모든 대문자 b에 대하여, 
  문자열 A에 존재하는 대문자 b를 대응하는 소문자로 치환한 문자열을 C라고 하자. 
  입력으로 문자열 A와 문자 목록 B가 주어지면 문자열 C를 출력하자.
입력
- 첫 번째 줄에 문자열 A가 주어진다.
  두 번째 줄에 문자 목록 B가 주어진다.
출력
- 첫 번째 줄에 문자열 C를 출력한다.
ex 1)
입력		출력
- ABabC     - aBabC
  A
ex 2)
입력        출력
- ABabC     - ababC
  A B D
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon26040 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      String word = st.nextToken();
      char ch = word.toLowerCase().charAt(0);
      s = s.replaceAll(word, String.valueOf(ch));
    }
    System.out.println(s);
  }
}
