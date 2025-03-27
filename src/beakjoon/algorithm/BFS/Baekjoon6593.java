package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon6593 {
  static int L, R, C, T;
  static int startX, startY, startZ;
  static int endX, endY, endZ;
  static char[][][] building;
  static boolean[][][] visited;
  static StringBuilder sb;
  static int[] dx = {-1, 1, 0, 0, 0, 0};
  static int[] dy = {0, 0, -1, 1, 0, 0};
  static int[] dz = {0, 0, 0, 0, -1, 1};

  private static class Position {
    int z, x, y, times;

    public Position(int z, int x, int y, int times) {
      this.z = z;
      this.x = x;
      this.y = y;
      this.times = times;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    sb = new StringBuilder();

    while (true) {
      st = new StringTokenizer(br.readLine());
      L = Integer.parseInt(st.nextToken());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());

      if (L == 0 && R == 0 && C == 0) break;

      building = new char[L][R][C];
      visited = new boolean[L][R][C];

      for (int i = 0; i < L; i++) {
        for (int j = 0; j < R; j++) {
          String rows = br.readLine();

          for (int k = 0; k < C; k++) {
            building[i][j][k] = rows.charAt(k);

            if (building[i][j][k] == 'S') {
              startZ = i;
              startX = j;
              startY = k;
            }

            if (building[i][j][k] == 'E') {
              endZ = i;
              endX = j;
              endY = k;
            }
          }
        }
        br.readLine();
      }
      bfs(startZ, startX, startY, T);

    }
    System.out.print(sb);
  }

  private static void bfs(int z, int x, int y, int t) {
    Queue<Position> queue = new LinkedList<>();
    queue.offer(new Position(z, x, y, t));
    visited[z][x][y] = true;

    while (!queue.isEmpty()) {
      Position cur = queue.poll();
      int nowZ = cur.z;
      int nowX = cur.x;
      int nowY = cur.y;
      int time = cur.times;

      if (building[nowZ][nowX][nowY] == 'E') {
        sb.append("Escaped in " + time + " minute(s).").append('\n');
        return;
      }

      for (int k = 0; k < 6; k++) {
        int nz = nowZ + dz[k];
        int nx = nowX + dx[k];
        int ny = nowY + dy[k];

        if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L) continue;
        if (building[nz][nx][ny] == '#') continue;
        if (visited[nz][nx][ny]) continue;

        visited[nz][nx][ny] = true;
        queue.offer(new Position(nz, nx, ny, time + 1));
      }
    }

    sb.append("Trapped!").append('\n');
  }
}
