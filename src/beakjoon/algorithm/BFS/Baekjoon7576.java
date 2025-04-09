package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {
  static int M, N, max;
  static int[][] boxes;
  static boolean[][] checked;
  static Queue<int[]> queue;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    max = 0;
    boxes = new int[N][M];
    checked = new boolean[N][M];
    queue = new LinkedList<>();
    boolean isDone = true;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        boxes[i][j] = Integer.parseInt(st.nextToken());

        if (boxes[i][j] == 1) {
          queue.add(new int[]{i, j, 0});
        }

        if (boxes[i][j] == 0) isDone = false;
      }
    }

    if (isDone) {
      System.out.print(0);
    }

    bfs();
    if (isChanged()) System.out.print(max);
    else System.out.print(-1);

  }

  private static boolean isChanged() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (boxes[i][j] == 0) return true;
      }
    }

    return false;
  }

  private static void bfs() {
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int x = now[0], y = now[1], count = now[2];

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];
        int ncount = count + 1;

        if (nx < 0 || ny < 0 || nx >= N || ny >= M || checked[nx][ny]) continue;
        if (boxes[nx][ny] == -1) continue;

        queue.add(new int[]{nx, ny, ncount});
        checked[nx][ny] = true;
        max = Math.min(max, ncount);
      }
    }
  }
}
