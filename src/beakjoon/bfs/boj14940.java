package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14940 {
  static int n, m, startX, startY;
  static int[][] map, result;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  static class Pos {
    int x, y;

    Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    result = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(result[i], -1);

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] == 0) result[i][j] = 0;
        if (map[i][j] == 2) {
          startX = i;
          startY = j;
        }
      }
    }

    bfs(startX, startY);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(result[i][j]).append(' ');
      }
      sb.append('\n');
    }
    System.out.print(sb);
  }

  private static void bfs(int x, int y) {
    Queue<Pos> queue = new LinkedList<>();
    result[x][y] = 0;
    queue.add(new Pos(x, y));

    while (!queue.isEmpty()) {
      Pos cur = queue.poll();

      for (int k = 0; k < 4; k++) {
        int nx = cur.x + dx[k];
        int ny = cur.y + dy[k];

        if (inInBounds(nx, ny) && map[nx][ny] == 1 && result[nx][ny] == -1) {
          result[nx][ny] = result[cur.x][cur.y] + 1;
          queue.add(new Pos(nx, ny));
        }
      }
    }
  }

  private static boolean inInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }
}
