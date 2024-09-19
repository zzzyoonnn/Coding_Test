package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2468 {
  static int n, standard;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    visited = new boolean[n][n];

    StringTokenizer st;
    int maxHeight = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        maxHeight = Math.max(maxHeight, arr[i][j]);
      }
    }

    int count;
    standard = maxHeight;
    int maxCount = -1;

    while (true) {
      count = 0;
      visited = new boolean[n][n];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (arr[i][j] > standard && !visited[i][j]) {
            dfs(i, j);
            count++;
          }
        }
      }

      maxCount = Math.max(maxCount, count);
      if (standard == 0) break;
      standard--;
    }

    System.out.println(maxCount);
  }

  public static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if (arr[nx][ny] > standard && !visited[nx][ny]) {
          dfs(nx, ny);
        }
      }
    }
  }
}
