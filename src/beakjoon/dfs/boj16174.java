package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16174 {
  static int n;
  static int[][] grid;
  static boolean[][] visited;
  static int[] dx = {1, 0}, dy = {0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    grid = new int[n][n];
    visited = new boolean[n][n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0);

    System.out.print(visited[n - 1][n - 1] ? "HaruHaru" : "Hing");
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    int now = grid[x][y];

    for (int k = 0; k < 2; k++) {
      int nx = x + (now * dx[k]);
      int ny = y + (now * dy[k]);

      if (isInBounds(nx, ny) && !visited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }
}
