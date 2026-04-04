package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17086 {
  static int n, m;
  static int[][] grid;
  static boolean[][] visited;
  static int[][] dist;
  static int[] dx = {1, -1, 0, 0, 1, 1 ,-1, -1}, dy = {0, 0, 1, -1, 1, -1, 1 ,-1};


  static class Pos {
    int x, y, dist;

    public Pos(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    grid = new int[n][m];
    visited = new boolean[n][m];
    dist = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      Arrays.fill(dist[i], -1);

      for (int j = 0; j < m; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0) {
          visited = new boolean[n][m];
          bfs(i, j);
        }
      }
    }

    int max = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        max = Math.max(max, dist[i][j]);
      }
    }

    System.out.print(max);
  }

  private static void bfs(int x, int y) {
    visited[x][y] = true;
    dist[x][y] = 0;
    Queue<Pos> queue = new LinkedList<>();
    queue.add(new Pos(x, y, 0));

    while (!queue.isEmpty()) {
      Pos cur = queue.poll();

      if (grid[cur.x][cur.y] == 1) {
        dist[x][y] = cur.dist;
        break;
      }

      for (int k = 0; k < 8; k++) {
        int nx = cur.x + dx[k];
        int ny = cur.y + dy[k];

        if (isInBounds(nx, ny) && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.add(new Pos(nx, ny, cur.dist + 1));
        }
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }
}
