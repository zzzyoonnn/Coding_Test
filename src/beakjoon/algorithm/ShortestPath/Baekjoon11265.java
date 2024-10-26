package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11265 {
  static int x, y, t;
  private static int[][] times;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());    // size of party
    int m = Integer.parseInt(st.nextToken());    // number of customer

    times = new int[n + 1][n + 1];

    final int INF = Integer.MAX_VALUE / 2;
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 1; j <= n; j++) {
        times[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          times[i][j] = Math.min(times[i][j], times[i][k] + times[k][j]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (times[a][b] <= c) sb.append("Enjoy other party");
      else sb.append("Stay here");

      sb.append('\n');
    }
    System.out.print(sb.toString());
  }
}
