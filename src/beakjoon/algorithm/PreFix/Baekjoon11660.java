package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11660 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());       // 표의 크기
    int m = Integer.parseInt(st.nextToken());       // 합을 구해야 하는 횟수

    int[][] arr = new int[n + 1][n + 1];        // 표
    int[][] dp = new int[n + 1][n + 1];         // 누적 합한 표

    // 표 채우기
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 1; j <= n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 누적 합 된 표 구하기
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
      }
    }

    // 합 구하기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());

      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];

      sb.append(sum).append('\n');
    }

    System.out.println(sb);
  }
}
