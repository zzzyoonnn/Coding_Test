package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon18405 {
  static int N, K, S, X, Y;
  static int[][] testState;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  private static class Virus implements Comparable<Virus> {
    int x, y, type, time;

    public Virus(int x, int y, int type, int time) {
      this.x = x;
      this.y = y;
      this.type = type;
      this.time = time;
    }

    @Override
    public int compareTo(Virus o) {
      return Integer.compare(this.type, o.type); // 낮은 바이러스 번호 먼저
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    testState = new int[N + 1][N + 1];
    PriorityQueue<Virus> pq = new PriorityQueue<>();

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        int state = Integer.parseInt(st.nextToken());
        testState[i][j] = state;

        if (state != 0) {
          pq.offer(new Virus(i, j, state, 0));
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    spreadVirus(pq);

    System.out.print(testState[X][Y]);

  }

  private static void spreadVirus(PriorityQueue<Virus> pq) {
    Queue<Virus> queue = new LinkedList<>();
    while (!pq.isEmpty()) {
      queue.offer(pq.poll());
    }

    while (!queue.isEmpty()) {
      Virus now = queue.poll();

      if (now.time == S) break;

      for (int d = 0; d < 4; d++) {
        int nx = now.x + dx[d];
        int ny = now.y + dy[d];

        if (isOutOfBounds(nx, ny)) continue;
        if (testState[nx][ny] == 0) {
          testState[nx][ny] = now.type;
          queue.offer(new Virus(nx, ny, now.type, now.time + 1));
        }
      }
    }
  }

  static boolean isOutOfBounds(int x, int y) {
    return x < 1 || y < 1 || x > N || y > N;
  }
}
