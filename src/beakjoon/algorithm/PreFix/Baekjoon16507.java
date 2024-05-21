package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16507 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());       // 가로 길이
    int c = Integer.parseInt(st.nextToken());       // 세로 길이
    int q = Integer.parseInt(st.nextToken());       // 평균을 알아볼 개수

    int[][] arr = new int[r + 1][c + 1];

    for (int i = 1; i <= r; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 1; j <= c; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 누적합된 표 구하기
    int[][] dp = new int[r + 1][c + 1];
    for (int i = 1; i <= r; i++) {
      for (int j = 1; j <= c; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
      }
    }

    // 각 사진의 밝기 평균 구하기
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];

      int total = (x2 - x1 + 1) * (y2 - y1 + 1);
      System.out.println(sum / total);
    }
  }
}
