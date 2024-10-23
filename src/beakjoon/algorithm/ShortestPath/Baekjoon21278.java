package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon21278 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of buildings
    int m = Integer.parseInt(st.nextToken());   // number of roads

    int[][] arr = new int[n + 1][n + 1];
    final int INF = Integer.MAX_VALUE / 2;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) continue;

        arr[i][j] = INF;
      }
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr[a][b] = 1;
      arr[b][a] = 1;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (i == j) continue;

          if (arr[i][k] != INF && arr[k][j] != INF) {
            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
          }
        }
      }
    }

    int[] answer = new int[2];
    int sumArr = INF;
    for (int i = 1; i <= n; i++) {
      int sum = 0;
      for (int j = 1; j <= n; j++) {
        sum += arr[i][j];
      }
      if (sum < sumArr) {
        sumArr = sum;
        answer[0] = i;
      }
    }

    int max = -1;
    for (int i = 1; i <= n; i++) {
      if (max < arr[answer[0]][i]) {
        max = arr[answer[0]][i];
        answer[1] = i;
      }
    }

    Arrays.sort(answer);

    int total = (sumArr * 2) - (arr[answer[0]][answer[1]] * 2);
    System.out.print(answer[0] + " " + answer[1] + " " + total);
  }
}
