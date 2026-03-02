package beakjoon.archive.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2206 {
  static int N, M;
  static char[][] map;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  private static class Position {
    int x;
    int y;
    boolean destroyed;
    int distance;

    public Position(int x, int y, boolean destroyed, int distance) {
      this.x = x;
      this.y = y;
      this.destroyed = destroyed;
      this.distance = distance;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    System.out.print(moveToNm(0, 0));
  }

  private static int moveToNm(int i, int j) {
    Queue<Position> q = new LinkedList<>();
    q.offer(new Position(i, j, false, 1));

    boolean[][][] visited = new boolean[N][M][2];
    visited[i][j][0] = true;

    while (!q.isEmpty()) {
      Position now = q.poll();
      int nowX = now.x;
      int nowY = now.y;
      boolean nowDestroyed = now.destroyed;
      int nowDistance = now.distance;

      if (nowX == N - 1 && nowY == M - 1) return nowDistance;

      for (int k = 0; k < 4; k++) {
        int nx = nowX + dx[k];
        int ny = nowY + dy[k];

        if (isOutOfBounds(nx, ny)) continue;
        if (map[nx][ny] == '0') {
          if (!visited[nx][ny][nowDestroyed ? 1 : 0]) {
            visited[nx][ny][nowDestroyed ? 1 : 0] = true;
            q.offer(new Position(nx, ny, nowDestroyed, nowDistance + 1));
          }
        } else if (map[nx][ny] == '1' && !nowDestroyed) {
          if (!visited[nx][ny][1]) {
            visited[nx][ny][1] = true;
            q.offer(new Position(nx, ny, true, nowDistance + 1));
          }
        }
      }
    }
    return -1;
  }

  static boolean isOutOfBounds(int x, int y) {
    return x < 0 || y < 0 || x >= N || y >= M;
  }
}
