package beakjoon.algorithm.implementation;
/*
문제
- 고려대학교의 영문 이름은 KOREA UNIVERSITY이다.
  영어 알파벳 대문자 K, O, R, E, A로만 이루어진 문자열 S가 주어진다. 
  S에서 0개 이상의 문자를 지웠을 때 “KOREAKOREAKOR” 처럼 ‘K’로 시작하고 
  각 글자가 ‘K’, ‘O’, ‘R’, ‘E’, ‘A’ 순서로 반복되는 문자열을 만들려고 한다. 
  이를 KOREA 문자열이라고 하자.
  문자열이 주어졌을 때, 0개 이상의 문자를 지워서 만들 수 있는 가장 긴 KOREA 문자열의 길이를 구하여라.
입력
- 첫 번째 줄에 문자열 S가 주어진다. 
  S는 영어 알파벳 대문자 K, O, R, E, A로만 이루어져 있으며, 
  문자열의 길이는 10 이상1,000 이하이다.
출력
- 첫 번째 줄에 만들 수 있는 가장 긴 KOREA 문자열의 길이를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon30700 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String korea = "KOREA";
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == korea.charAt(count % 5)) {
        count++;
      }
    }
    System.out.println(count);
  }
}
