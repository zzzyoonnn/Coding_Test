package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1926 {
  static int n, m, size;
  static boolean[][] map;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        if (Integer.parseInt(st.nextToken()) == 1) map[i][j] = true;
        else map[i][j] = false;
      }
    }

    int maxSize = 0;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j]) {
          size = 0;
          count++;
          dfs(i, j);
          maxSize = Math.max(maxSize, size);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(count).append('\n').append(maxSize);

    System.out.print(sb);
  }

  private static void dfs(int x, int y) {
    map[x][y] = false;
    size++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && map[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }
}
