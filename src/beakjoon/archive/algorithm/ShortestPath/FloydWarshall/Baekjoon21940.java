package beakjoon.archive.algorithm.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon21940 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of cities
    int m = Integer.parseInt(st.nextToken());   // number of roads

    final int INF = Integer.MAX_VALUE / 2;
    int[][] roads = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        roads[i][j] = INF;
      }
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());

      roads[a][b] = t;
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

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(roads[i][j] + " ");
      }
      System.out.println();
    }

    int k = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int[] friends = new int[k];
    for (int i = 0; i < k; i++) {
      friends[i] = Integer.parseInt(st.nextToken());
    }

    int[] times = new int[n + 1];
    times[0] = INF;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        times[j] += roads[i][j] + roads[j][i];
      }
    }

    System.out.println(Arrays.toString(times));
    int min = Arrays.stream(times).min().getAsInt();
    for (int i = 1; i <= n; i++) {
      if (times[i] == min) System.out.print(i + " ");
    }
  }
}
