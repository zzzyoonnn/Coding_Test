package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1012 {
  static int n, m, count;
  static boolean[][] visited;
  static int[][] map;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      map = new int[m][n];
      visited = new boolean[m][n];

      int k = Integer.parseInt(st.nextToken());
      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        map[a][b] = 1;
      }

      count = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (!visited[i][j] && map[i][j] == 1) {
            count++;
            dfs(i, j);
          }
        }
      }

      System.out.println(count);
    }
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }
}
