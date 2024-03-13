package beakjoon.algorithm.implementation;
/*
문제
- 10년 동안 도박판에서 야바위를 한 영훈은 이제 보지 않고도 구슬이 있는 컵을 맞추는 지경에 이르렀다.
  이런 영훈을 골탕 먹이기 위해 문자열로 야바위를 하려고 한다.
  T번 동안 문자열 S의 A번째 위치에 있는 문자와 B번째 위치에 있는 문자를 바꾼 결과를 출력하는 프로그램을 작성하시오.
입력
- 첫 번째 줄에 문자열 S가 주어지고 두 번째 줄에 T가 주어진다. 
  문자열 S의 길이는 100보다 작거나 같은 자연수이며, 알파벳 대소문자와 하이픈(-)으로만 이루어져 있다. 
  T는 50보다 작거나 같은 자연수이다.
  그 다음 T개의 줄에 걸쳐 A와 B가 주어진다.
  A와 B는 문자열의 길이보다 작은 음이 아닌 정수이며, 문자열의 맨 처음 글자는 0번째 글자이다.
출력
- 바뀐 문자열의 결과를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15814 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();       // 문자열
    int t = Integer.parseInt(br.readLine());        // 테스트 케이스 개수
    char[] arr = s.toCharArray();
    StringTokenizer st;

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      char temp = arr[a];
      arr[a] = arr[b];
      arr[b] = temp;
    }

    for (char c : arr) {
      System.out.print(c);
    }
  }
}
