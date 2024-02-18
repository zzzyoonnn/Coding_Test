package beakjoon.algorithm.implementation;
/*
문제
- 알파벳 소문자 d, b, q, p는 상하좌우로 뒤집으면 d, b, q, p 중 하나로 변하는 특별한 성질이 있다. 
  그 성질을 정리하면 다음과 같다.
    d를 상하로 뒤집으면 q로, 좌우로 뒤집으면 b로 변한다.
    b를 상하로 뒤집으면 p로, 좌우로 뒤집으면 d로 변한다.
    q를 상하로 뒤집으면 d로, 좌우로 뒤집으면 p로 변한다.
    p를 상하로 뒤집으면 b로, 좌우로 뒤집으면 q로 변한다.
  N행 N열의 격자의 각 칸에 d, b, q, p 중 하나가 들어 있다. 
  이 격자에 들어 있는 각각의 알파벳을 주어진 방향으로 뒤집은 결과를 구해보자.
입력
- 첫째 줄에 정수 N(1 <= N <= 10)과 각각의 알파벳을 뒤집는 방향을 의미하는 정수 D(1 <= D <= 2)가 공백으로 구분되어 주어진다. 
  D=1는 상하 방향, D=2는 좌우 방향을 의미한다.
  둘째 줄부터 N개의 줄에 길이가 N인 문자열이 주어진다. 
  i번째 줄의 j번째 문자는 격자의 i행 j열에 들어 있는 문자를 의미한다. 
  격자의 각 칸에는 알파벳 소문자 d, b, q, p 중 하나가 들어 있다.
출력
- 주어진 격자에 들어있는 각각의 알파벳을 주어진 방향으로 뒤집은 결과를 구해보자.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon30032 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      StringBuilder sb = new StringBuilder();
      if (d == 1) {
        for (int j = 0; j < s.length(); j++) {
          if (s.charAt(j) == 'd') sb.append('q');
          else if (s.charAt(j) == 'b') sb.append('p');
          else if (s.charAt(j) == 'q') sb.append('d');
          else if (s.charAt(j) == 'p') sb.append('b');
        }
      } else if (d == 2) {
        for (int j = 0; j < s.length(); j++) {
          if (s.charAt(j) == 'd') sb.append('b');
          else if (s.charAt(j) == 'b') sb.append('d');
          else if (s.charAt(j) == 'q') sb.append('p');
          else if (s.charAt(j) == 'p') sb.append('q');
        }
      }

      System.out.println(sb);
    }
  }
}
