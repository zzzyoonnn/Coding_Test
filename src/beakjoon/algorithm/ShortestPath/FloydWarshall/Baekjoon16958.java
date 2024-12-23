package beakjoon.algorithm.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon16958 {
  private static int n, t, m;
  private static City[] cities;
  private static int[][] times;
  private static final int INF = Integer.MAX_VALUE / 2;

  private static class City {
    int type;
    int x;
    int y;

    public City(int type, int x, int y) {
      this.type = type;
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());   // number of cities
    t = Integer.parseInt(st.nextToken());   // time

    cities = new City[n + 1];
    times = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      cities[i] = new City(type, x, y);
      Arrays.fill(times[i], INF);
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i != j) {
          times[i][j] = calculateTime(cities[i].x, cities[i].y, cities[j].x, cities[j].y);

          if (cities[i].type == 1 && cities[j].type == 1) {
            times[i][j] = Math.min(times[i][j], t);
          }
        }
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
    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append(times[a][b]).append("\n");
    }
    System.out.print(sb.toString());
  }

  private static int calculateTime(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
}
