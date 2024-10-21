package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14938 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of regions
    int m = Integer.parseInt(st.nextToken());   // YE's range
    int r = Integer.parseInt(st.nextToken());   // number of roads

    int[] items = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      items[i] = Integer.parseInt(st.nextToken());
    }

    final int INF = Integer.MAX_VALUE;
    int[][] roads = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) roads[i][j] = 0;
        else roads[i][j] = INF;
      }
    }

    for (int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());

      roads[a][b] = l;
      roads[b][a] = l;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (roads[i][k] != INF && roads[k][j] != INF) {
            roads[i][j] = Math.min(roads[i][j], roads[i][k] + roads[k][j]);
          }
        }
      }
    }

    int sum;
    int max = 0;
    for (int i = 1; i <= n; i++) {
      sum = 0;

      for (int j = 1; j <= n; j++) {
        if (roads[i][j] <= m) sum += items[j];
      }

      max = Math.max(max, sum);
    }

    System.out.println(max);
  }
}
