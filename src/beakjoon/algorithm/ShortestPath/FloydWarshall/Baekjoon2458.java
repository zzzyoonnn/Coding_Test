package beakjoon.algorithm.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2458 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of students
    int m = Integer.parseInt(st.nextToken());   // number of comparisons

    int[][] arr = new int[n + 1][n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr[a][b] = 1;
      arr[b][a] = -1;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (arr[k][j] != 0 && arr[i][k] == arr[k][j]) {
            arr[i][j] = arr[k][j];
          }
        }
      }
    }

    int[] light = new int[n + 1];
    int[] heavy = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (arr[i][j] == 1) heavy[i]++;
        if (arr[i][j] == -1) light[i]++;
      }
    }

    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (heavy[i] + light[i] == (n - 1)) count++;
    }

    System.out.println(count);
  }
}
