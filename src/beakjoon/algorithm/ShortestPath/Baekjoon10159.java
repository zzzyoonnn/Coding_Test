package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10159 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    final int INF = Integer.MAX_VALUE / 2;
    int[][] things = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        things[i][j] = INF;
      }
    }

    StringTokenizer st;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      things[a][b] = 1;
      things[b][a] = -1;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (things[k][j] != INF && things[i][k] == things[k][j]) {
            things[i][j] = Math.min(things[i][j], things[i][k]);
          }
        }
      }
    }

    int[] answer = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (things[i][j] != INF) answer[i]++;
      }
    }

    for (int i = 1; i <= n; i++) {
      System.out.println(n - answer[i] - 1);
    }
  }
}
