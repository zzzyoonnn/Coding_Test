package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2468 {
  static int n, count, max;
  static int[][] map;
  static boolean[][] checked;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];

    count = 0;
    max = 0;
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        max = Math.max(max, map[i][j]);
      }
    }

    int safe = 0;
    for (int rain = 0; rain <= max; rain++) {
      count = 0;
      checked = new boolean[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (!checked[i][j] && map[i][j] > rain) {
            count++;
            dfs(i, j, rain);
          }
        }
      }
      safe = Math.max(safe, count);
    }

    System.out.println(safe);
  }

  private static void dfs(int x, int y, int rain) {
    checked[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && !checked[nx][ny] && map[nx][ny] > rain) {
        dfs(nx, ny, rain);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }
}
