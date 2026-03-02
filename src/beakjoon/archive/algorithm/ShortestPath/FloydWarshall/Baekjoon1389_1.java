package beakjoon.archive.algorithm.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1389_1 {
  static int n, m;
  static int INF = Integer.MAX_VALUE;
  static int[][] arr;
  static int[] result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n + 1][n + 1];
    result = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      Arrays.fill(arr[i], INF);
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr[a][b] = 1;
      arr[b][a] = 1;
    }

    for (int k = 0; k <= n; k++) {
      for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
          if (arr[i][k] != INF && arr[k][j] != INF) {
            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
          }
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      int temp = 0;
      for (int j = 1; j <= n; j++) {
        if (i == j) continue;

        temp += arr[i][j];
      }
      result[i] = temp;
    }

    int min = INF;
    int minIndex = INF;
    for (int i = 1; i <= n; i++) {
      if (result[i] < min) {
        min = result[i];
        minIndex = i;
      }
    }

    System.out.println(minIndex);
  }
}
