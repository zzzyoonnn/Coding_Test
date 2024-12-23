package beakjoon.algorithm.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11403 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int INF = Integer.MAX_VALUE;
    int[][] arr = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        arr[i][j] = INF;
      }
    }

    StringTokenizer st;
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int num = Integer.parseInt(st.nextToken());

        if (num == 1) {
          arr[i][j] = 1;
          //arr[j][i] = 1;
        }
      }
    }

    // Floyd-Warshall Algorithm
    for (int k = 1; k <= n; k++) {      // transfer node
      for (int i = 1; i <= n; i++) {    // start node
        for (int j = 1; j <= n; j++) {  // end node
          if (arr[i][k] != INF && arr[k][j] != INF) {
            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (arr[i][j] != INF) sb.append(1).append(' ');
        else sb.append(0).append(' ');
      }
      sb.append("\n");
    }

    System.out.print(sb.toString());
  }
}
