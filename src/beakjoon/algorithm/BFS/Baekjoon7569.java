package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7569 {
  static int N, M, H, max;
  static int[][][] boxes;
  static int[] dx = {1, -1, 0, 0, 0, 0};
  static int[] dy = {0, 0, 1, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    boxes = new int[H][N][M];

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          boxes[i][j][k] = Integer.parseInt(st.nextToken());
        }
      }
    }

    max = 0;
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
          if (boxes[i][j][k] == 1) q.offer(new int[]{i, j, k});
        }
      }
    }

    bfs(q);
    if (max == 1 || max == 0) max++;
    System.out.print(checkBox() ? -1 : max - 1);
  }

  private static boolean checkBox() {
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
          if (boxes[i][j][k] == 0) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private static void bfs(Queue<int[]> q) {
    while (!q.isEmpty()) {
      int[] now = q.poll();
      int z = now[0];
      int x = now[1];
      int y = now[2];

      for (int idx = 0; idx < 6; idx++) {
        int nz = z + dz[idx];
        int nx = x + dx[idx];
        int ny = y + dy[idx];

        if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
        if (boxes[nz][nx][ny] != 0) continue;

        boxes[nz][nx][ny] = boxes[z][x][y] + 1;
        max = Math.max(max, boxes[nz][nx][ny]);
        q.offer(new int[]{nz, nx, ny});
      }
    }
  }
}
