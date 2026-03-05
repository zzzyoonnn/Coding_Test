package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178 {
  static int n, m;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
  static char[][] maze;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    maze = new char[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      maze[i] = br.readLine().toCharArray();
    }

    int result = bfs(0, 0);
    System.out.print(result);
  }

  private static int bfs(int startX, int startY) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startX, startY, 1});
    visited[startX][startY] = true;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0];
      int y = cur[1];
      int count = cur[2];

      if (x == n - 1 && y == m - 1) return count;

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if (isInBounds(nx, ny) && maze[nx][ny] == '1' && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.add(new int[]{nx, ny, count + 1});
        }
      }
    }
    return -1;
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }
}
