package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1303 {
  static int n, m, count, powerB, powerW;
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new char[m][n];
    visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      map[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          count = 0;
          if (map[i][j] == 'B') {
            dfs(i, j);

            powerB += (count * count);
          }

          if (map[i][j] == 'W') {
            dfs(i, j);

            powerW += (count * count);
          }
        }
      }
    }

    System.out.print(powerW + " " + powerB);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;
    count++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && map[nx][ny] == map[x][y] && !visited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }
}
