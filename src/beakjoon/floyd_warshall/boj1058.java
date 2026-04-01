package beakjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1058 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    final int INF = Integer.MAX_VALUE;

    int[][] grid = new int[n][n];
    char[][] friends = new char[n][n];
    for (int i = 0; i < n; i++) {
      friends[i] = br.readLine().toCharArray();
      Arrays.fill(grid[i], INF);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (friends[i][j] == 'Y') grid[i][j] = 1;
      }
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][k] != INF && grid[k][j] != INF) {
            grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
          }
        }
      }
    }

    int max = 0;
    int count;
    for (int i = 0; i < n; i++) {
      count = 0;
      for (int j = 0; j < n; j++) {
        if (i == j) continue;
        if (grid[i][j] <= 2) count++;
      }

      max = Math.max(max, count);
    }

    System.out.print(max);
  }
}
