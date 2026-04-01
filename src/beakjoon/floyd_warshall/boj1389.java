package beakjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1389 {
  static int n, m, INF = Integer.MAX_VALUE / 2;;
  static int[][] number;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    number = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      Arrays.fill(number[i], INF);
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      number[a][b] = 1;
      number[b][a] = 1;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (number[i][k] != INF && number[k][j] != INF) {
            number[i][j] = Math.min(number[i][j], number[i][k] + number[k][j]);
          }
        }
      }
    }

    int[] result = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        result[i] += number[i][j];
      }
    }

    int min = INF;
    int index = -1;
    for (int i = 1; i <= n; i++) {
      if (min > result[i]) {
        min = result[i];
        index = i;
      }
    }
    System.out.print(index);
  }
}
