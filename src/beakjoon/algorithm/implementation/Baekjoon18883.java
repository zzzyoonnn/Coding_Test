package beakjoon.algorithm.implementation;
/*
문제
- 자연수 N, M이 주어졌을 때, 1부터 N×M까지 출력 형식대로 출력해보자.
입력
- 첫째 줄에 공백 한 칸으로 구분한 N, M이 주어진다. 
  두 수는 1,000보다 작거나 같은 자연수이다.
출력
- 총 N개의 줄을 출력해야 한다. 
  각 줄에는 M개의 정수를 공백 한 칸으로 구분해 출력해야 한다. 
  1번 줄에는 1부터 M까지, 2번 줄에는 M+1부터 2×M까지, ..., N번 줄에는 (N-1)×M+1부터 N×M까지 출력해야 한다.
  모든 줄의 시작과 끝에 공백이 있으면 안되고, 모든 줄은 줄바꿈(\n)으로 끝나야 한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon18883 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n * m; i++) {
      sb.append(i);
      if (i % m != 0) sb.append(' ');
      else sb.append('\n');
    }
    System.out.print(sb);
  }
}
