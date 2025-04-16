package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon17836 {
  static int N, M, T;
  static int[][] castle;
  static boolean[][][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  private static class Warrior {
    int x;
    int y;
    int time;
    boolean state;

    public Warrior(int x, int y, int time, boolean state) {
      this.x = x;
      this.y = y;
      this.time = time;
      this.state = state;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    castle = new int[N + 1][M + 1];
    visited = new boolean[N + 1][M + 1][2];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        castle[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = findPrincess();
    System.out.print(result == -1 ? "Fail" : result);
  }

  private static int findPrincess() {
    Queue<Warrior> queue = new LinkedList<>();
    queue.add(new Warrior(1, 1, 0, false));
    visited[1][1][0] = true;

    while (!queue.isEmpty()) {
      Warrior w = queue.poll();
      int x = w.x;
      int y = w.y;
      int time = w.time;
      boolean state = w.state;

      if (x == N && y == M) {
        return time;
      }

      if (time > T) break;

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];
        int nTime = time + 1;
        boolean nState = state;

        if (isOutOfBounds(nx, ny)) continue;
        if (visited[nx][ny][nState ? 1 : 0]) continue;
        if (!nState && castle[nx][ny] == 1) continue;
        if (castle[nx][ny] == 2) nState = true;

        queue.offer(new Warrior(nx, ny, nTime, nState));
        visited[nx][ny][nState ? 1 : 0] = true;
      }
    }

    return -1;
  }

  private static boolean isOutOfBounds(int x, int y) {
    return x < 1 || y < 1 || x > N || y > M;
  }
}
