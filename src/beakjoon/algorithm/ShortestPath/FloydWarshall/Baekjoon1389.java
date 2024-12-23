package beakjoon.algorithm.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1389 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of users
    int m = Integer.parseInt(st.nextToken());   // number of friends

    int INF = Integer.MAX_VALUE;
    int[][] relationships = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        relationships[i][j] = INF;
      }
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      relationships[a][b] = 1;
      relationships[b][a] = 1;
    }

    for (int k = 1; k <= n; k++) {      // transfer node
      for (int i = 1; i <= n; i++) {    // start node
        for (int j = 1; j <= n; j++) {  // end node
          if (relationships[i][k] != INF && relationships[k][j] != INF && relationships[i][j] > relationships[i][k] + relationships[k][j]) {
            relationships[i][j] = relationships[i][k] + relationships[k][j];
          }
        }
      }
    }

    int index = 0;
    int min = INF;
    int total;
    int[] sum = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      total = 0;
      for (int j = 1; j <= n; j++) {
        total += relationships[i][j];
      }
      if (total < min) {
        index = i;
        min = total;
      }
    }

    System.out.print(index);
  }
}
