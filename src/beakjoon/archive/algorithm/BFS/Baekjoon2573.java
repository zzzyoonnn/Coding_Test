package beakjoon.archive.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2573 {
  static int N, M;
  static int[][] sea, iceberg;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    sea = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        sea[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int year = 0;

    while (true) {
      int icebergCount = countIcebergs();

      if (icebergCount == 0) {
        year = 0;
        break;
      }

      if (icebergCount >= 2) {
        break;
      }

      meltIcebergs();
      year++;
    }

    System.out.print(year);
  }

  private static int countIcebergs() {
    visited = new boolean[N][M];
    int count = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && sea[i][j] > 0) {
          bfs(i, j);
          count++;
        }
      }
    }

    return count;
  }

  private static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int nowX = now[0];
      int nowY = now[1];

      for (int i = 0; i < 4; i++) {
        int nx = nowX + dx[i];
        int ny = nowY + dy[i];

        if (isOutOfBounds(nx, ny)) continue;
        if (visited[nx][ny]) continue;
        if (sea[nx][ny] == 0) continue;

        visited[nx][ny] = true;
        queue.offer(new int[]{nx, ny});
      }
    }
  }


  private static void meltIcebergs() {
    int[][] iceberg = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (sea[i][j] > 0) {
          int waterCount = 0;

          for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (isOutOfBounds(nx, ny)) continue;
            if (sea[nx][ny] == 0) waterCount++;
          }

          iceberg[i][j] = Math.max(sea[i][j] - waterCount, 0);
        }
      }
    }

    sea = iceberg;
  }

  private static boolean isOutOfBounds(int x, int y) {
    return x < 0 || y < 0 || x >= N || y >= M;
  }
}
