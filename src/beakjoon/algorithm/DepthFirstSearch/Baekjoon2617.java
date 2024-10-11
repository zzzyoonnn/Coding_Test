package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2617 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n + 1][n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      // Floyd-Warshall Algorithm
      arr[a][b] = 1;
      arr[b][a] = -1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        for (int k = 1; k <= n; k++) {
          if (arr[k][i] != 0 && arr[j][i] == arr[i][k]) {
            arr[j][k] = arr[j][i];
          }
        }
      }
    }

    int[] heavy = new int[n + 1];
    int[] light = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (arr[i][j] == 1) heavy[i]++;
        if (arr[i][j] == -1) light[i]++;
      }
    }

//    System.out.println(Arrays.toString(heavy));
//    System.out.println(Arrays.toString(light));

    int answer = 0;
    int standard = (n + 1) / 2;
//    System.out.println(standard);
    for (int i = 1; i <= n; i++) {
      if (heavy[i] >= standard) answer++;
      if (light[i] >= standard) answer++;
    }

    System.out.print(answer);
  }
}
