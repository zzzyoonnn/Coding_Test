package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11404 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // the number of cities
    int m = Integer.parseInt(br.readLine());    // the number of buses

    int[][] routes = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        routes[i][j] = Integer.MAX_VALUE;

        if (i == j) routes[i][j] = 0;
      }
    }

    StringTokenizer st;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());   // origin
      int b = Integer.parseInt(st.nextToken());   // destination
      int c = Integer.parseInt(st.nextToken());   // pee

      routes[a][b] = Math.min(routes[a][b], c);
    }

    for (int k = 1; k <= n; k++) {      // transfer point
      for (int i = 1; i <= n; i++) {    // start point
        for (int j = 1; j <= n; j++) {  // end point
          if (routes[i][k] != Integer.MAX_VALUE && routes[k][j] != Integer.MAX_VALUE && routes[i][j] > routes[i][k] + routes[k][j]) {
            routes[i][j] = routes[i][k] + routes[k][j];
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (routes[i][j] == Integer.MAX_VALUE) routes[i][j] = 0;

        sb.append(routes[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}
