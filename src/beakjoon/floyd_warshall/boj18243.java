package beakjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj18243 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] relationship = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) Arrays.fill(relationship[i], 7);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      relationship[a][b] = 1;
      relationship[b][a] = 1;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          relationship[i][j] = Math.min(relationship[i][k] + relationship[k][j], relationship[i][j]);
        }
      }
    }

    boolean result = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (relationship[i][j] > 6) {
          result = false;
          break;
        }
      }
    }
    System.out.print(result ? "Small World!" : "Big World!");
  }
}
