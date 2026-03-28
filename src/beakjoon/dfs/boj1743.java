package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1743 {
  static int n, m, max, count;
  static boolean[][] map;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    map = new boolean[n + 1][m + 1];
    visited = new boolean[n + 1][m + 1];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      map[r][c] = true;
    }

    max = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (map[i][j]) {
          count = 0;
          dfs(i, j);
          max = Math.max(max, count);
        }
      }
    }

    System.out.print(max);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;
    count++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && map[nx][ny] && !visited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x > 0 && x <= n && y > 0 && y <= m;
  }
}
