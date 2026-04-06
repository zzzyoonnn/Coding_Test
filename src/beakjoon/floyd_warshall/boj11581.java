package beakjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11581 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    boolean[][] roads = new boolean[n + 1][n + 1];

    int count, next;
    StringTokenizer st;
    for (int i = 1; i < n; i++) {
      count = Integer.parseInt(br.readLine());

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < count; j++) {
        next = Integer.parseInt(st.nextToken());

        roads[i][next] = true;
      }
    }


    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (roads[i][k] && roads[k][j]) {
            roads[i][j] = true;
          }
        }
      }
    }

    boolean result = true;
    for (int i = 1; i <= n; i++) {
      if (roads[1][i] && roads[i][i]) {
        result = false;
        break;
      }
    }
    System.out.print(result ? "NO CYCLE" : "CYCLE");
  }
}
