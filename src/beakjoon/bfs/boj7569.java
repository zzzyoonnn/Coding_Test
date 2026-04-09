package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7569 {
  static int n, m, h;
  static boolean started, isDone;
  static int[][][] boxes;
  static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

  static class Pos {
    int z, x, y;

    Pos(int z, int x, int y) {
      this.z = z;
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    boxes = new int[h][n][m];
    started = false;
    isDone = true;

    Queue<Pos> queue = new LinkedList<>();

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < m; k++) {
          boxes[i][j][k] = Integer.parseInt(st.nextToken());

          if (boxes[i][j][k] == 1) {
            queue.add(new Pos(i, j, k));
          }

          if (boxes[i][j][k] == 0) started = true;
        }
      }
    }

    while (!queue.isEmpty()) {
      Pos cur = queue.poll();

      for (int[] d : dir) {
        int nz = cur.z + d[0];
        int nx = cur.x + d[1];
        int ny = cur.y + d[2];

        if (isInBounds(nz, nx, ny) && boxes[nz][nx][ny] == 0) {
          boxes[nz][nx][ny] = boxes[cur.z][cur.x][cur.y] + 1;
          queue.add(new Pos(nz, nx, ny));
        }
      }
    }

    int max = -1;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (boxes[i][j][k] == 0) {
            isDone = false;
            break;
          }

          max = Math.max(max, boxes[i][j][k]);
        }
      }
    }

    if (!started) System.out.print(0);
    else if (!isDone) System.out.print(-1);
    else System.out.print(max - 1);
  }

  private static boolean isInBounds(int z, int x, int y) {
    return z >= 0 && z < h && x >= 0 && x < n && y >= 0 && y < m;
  }
}
