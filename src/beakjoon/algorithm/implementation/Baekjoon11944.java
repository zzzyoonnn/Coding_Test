package beakjoon.algorithm.implementation;
/*
문제
- 문제는 매우 간단하다. 
  N을 N번 출력하는 프로그램을 작성하여라. 
  다만, 답이 길어지는 경우 답의 앞 M자리만 출력한다.
입력
- 첫 번째 줄에는 N, M이 주어진다. (1 ≤ N, M ≤ 2016)
출력
- N을 N번 출력한다. 만약 답이 길어지면 답의 앞 M자리를 출력한다.
ex 1)
입력      출력
- 20 16   - 2020202020202020
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11944 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      sb.append(n);
    }

    if (sb.length() > m) System.out.println(sb.toString().substring(0, m));
    else System.out.println(sb.toString());
  }
}