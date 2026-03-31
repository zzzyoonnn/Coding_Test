package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14716 {
  static int m, n;
  static int[][] grid;
  static boolean[][] checked;
  static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1}, dy = {0, 0, -1, 1, 1,-1, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    grid = new int[m][n];
    checked = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && !checked[i][j]) {
          count++;
          dfs(i, j);
        }
      }
    }

    System.out.print(count);
  }

  private static void dfs(int x, int y) {
    checked[x][y] = true;

    for (int k = 0; k < 8; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && grid[nx][ny] == 1 && !checked[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }
}
