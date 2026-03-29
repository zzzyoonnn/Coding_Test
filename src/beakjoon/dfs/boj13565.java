package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13565 {
  static int m, n;
  static char[][] grid;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    grid = new char[m][n];
    for (int i = 0; i < m; i++) {
      grid[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < n; i++) {
      if (grid[1][i] == '0') dfs(1, i);
    }

    boolean result = false;
    for (int i = 0; i < n; i++) {
      if (grid[m - 1][i] == '2') {
        result = true;
        break;
      }
    }

    System.out.print(result ? "YES" : "NO");
  }

  private static void dfs(int x, int y) {
    grid[x][y] = '2';

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && grid[nx][ny] == '0') {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }
}
