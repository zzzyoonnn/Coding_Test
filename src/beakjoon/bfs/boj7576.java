package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576 {
  static int n, m, day;
  static int[][] box;
  static boolean started;
  static Queue<Pos> queue;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static class Pos {
    int x, y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    box = new int[n][m];

    started = false;
    queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());

        if (box[i][j] == 0) started = true;
        if (box[i][j] == 1) queue.add(new Pos(i, j));
      }
    }

    bfs();

    day = 0;
    boolean isDone = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (box[i][j] == 0) {
          isDone = false;
          break;
        }
        day = Math.max(day, box[i][j]);

      }
    }

    if (!started) System.out.print(0);
    else if (!isDone) System.out.print(-1);
    else System.out.print(day - 1);
  }

  private static void bfs() {
    while (!queue.isEmpty()) {
      Pos cur = queue.poll();

      for (int k = 0; k < 4; k++) {
        int nx = cur.x + dx[k];
        int ny = cur.y + dy[k];

        if (isInBounds(nx, ny) && box[nx][ny] == 0) {
          box[nx][ny] = box[cur.x][cur.y] + 1;
          queue.add(new Pos(nx, ny));
        }
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }
}
