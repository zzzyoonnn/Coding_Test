package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10026 {
  static int n, on, xn;
  static char[][] grid;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    grid = new char[n][n];

    for (int i = 0; i < n; i++) {
      grid[i] = br.readLine().toCharArray();
    }

    xn = 0;
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          xn++;
          dfs(i, j, grid[i][j], false);
        }
      }
    }

    on = 0;
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          on++;
          dfs(i, j, grid[i][j], true);
        }
      }
    }

    System.out.print(xn + " " + on);
  }

  private static void dfs(int x, int y, char now, boolean isColorBlind) {
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (!isInBounds(nx, ny) || visited[nx][ny]) continue;

      if (isSameColor(now, grid[nx][ny], isColorBlind)) {
        dfs(nx, ny, now, isColorBlind);
      }
    }
  }

  private static boolean isSameColor(char a, char b, boolean isColorBlind) {
    if (a == b) return true;
    if (isColorBlind) return (a == 'R' && b == 'G') || (a == 'G' && b == 'R');
    return false;
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }
}
