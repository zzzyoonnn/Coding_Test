package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj4963 {
  static int w, h, count;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1}, dy = {0, 0, -1, 1, 1, -1, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    while(true) {
      st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      if (w == 0 && h == 0) break;
      map = new int[h][w];
      visited = new boolean[h][w];

      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < w; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      count = 0;
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (map[i][j] == 1 && !visited[i][j]) {
            count++;
            dfs(i, j);
          }
        }
      }
      sb.append(count).append("\n");

    }

    System.out.print(sb);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int k = 0; k < 8; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < h && y >= 0 && y < w;
  }
}
