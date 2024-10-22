package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1613 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    final int INF = Integer.MAX_VALUE / 2;
    int[][] histories = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        histories[i][j] = INF;
      }
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      // sequence : a -> b
      histories[a][b] = 1;
      histories[b][a] = -1;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (histories[i][j] == INF && histories[i][k] != INF &&histories[i][k] == histories[k][j]) {
            histories[i][j] = histories[i][k];
          }
        }
      }
    }

    int knows = Integer.parseInt(br.readLine());
    for (int i = 0; i < knows; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (histories[a][b] == -1) System.out.println(1);
      else if (histories[a][b] == 1) System.out.println(-1);
      else System.out.println(0);
    }
  }
}
