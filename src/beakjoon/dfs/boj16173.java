package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16173 {
  static int n;
  static int[] dx = {1, 0}, dy = {0, 1};
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    visited = new boolean[n][n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.print(dfs(0, 0) ? "HaruHaru" : "Hing");
  }

  private static boolean dfs(int x, int y) {
    visited[x][y] = true;

    if (x == n - 1 && y == n - 1) return true;

    for (int k = 0; k < 2; k++) {
      int nx = x + (map[x][y] * dx[k]);
      int ny = y + (map[x][y] * dy[k]);

      if (isInBounds(nx, ny) && !visited[nx][ny]) {
        if (dfs(nx, ny)) return true;
      }
    }

    return false;
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && y >= 0 && x < n && y < n;
  }
}
