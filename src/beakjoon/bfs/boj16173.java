package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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

    System.out.print(bfs(0, 0) ? "HaruHaru" : "Hing");
  }

  private static boolean bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int curX = cur[0];
      int curY = cur[1];

      if (curX == n - 1 && curY == n - 1) return true;

      for (int k = 0; k < 2; k++) {
        int nx = curX + (map[curX][curY] * dx[k]);
        int ny = curY + (map[curX][curY] * dy[k]);

        if (isInBounds(nx, ny) && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.add(new int[]{nx, ny});
        }
      }
    }
      return false;
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && y >= 0 && x < n && y < n;
  }
}
