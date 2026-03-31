package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11123 {
  static int h, w, count;
  static char[][] grid;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < t; tc++) {
      st = new StringTokenizer(br.readLine());
      h = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());

      grid = new char[h][w];
      visited = new boolean[h][w];

      for (int i = 0; i < h; i++) {
        grid[i] = br.readLine().toCharArray();
      }

      count = 0;
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (grid[i][j] == '#' && !visited[i][j]) {
            count++;
            dfs(i, j);
          }
        }
      }

      sb.append(count).append('\n');
    }
    System.out.print(sb);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && grid[nx][ny] == '#' && !visited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < h && y >= 0 && y < w;
  }
}
