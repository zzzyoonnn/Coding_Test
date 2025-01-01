package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1584 {
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  private static class Node implements Comparable<Node> {
    int x;
    int y;
    int life;

    public Node(int x, int y, int life) {
      this.x =x;
      this.y = y;
      this.life = life;
    }

    @Override
    public int compareTo(Node o) {
      return this.life - o.life;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] map = new int[501][501];
    boolean[][] visited = new boolean[501][501];

    int N = Integer.parseInt(br.readLine());    // 위험한 구역 수
    StringTokenizer st;

    for (int input = 0; input < N; input++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());

      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int startX = Math.min(x1, x2);
      int startY = Math.min(y1, y2);

      int endX = Math.max(x1, x2);
      int endY = Math.max(y1, y2);

      for (int x = startX; x <= endX; x++) {
        for (int y = startY; y <= endY; y++) {
          map[x][y] = 1;
        }
      }
    }

    int M = Integer.parseInt(br.readLine());    // 죽음의 구역

    for (int input = 0; input < M; input++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());

      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int startX = Math.min(x1, x2);
      int startY = Math.min(y1, y2);

      int endX = Math.max(x1, x2);
      int endY = Math.max(y1, y2);

      for (int x = startX; x <= endX; x++) {
        for (int y = startY; y <= endY; y++) {
          map[x][y] = -1;
        }
      }
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(0, 0, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (now.x == 500 && now.y == 500) {
        System.out.print(now.life);
        System.exit(0);
      }

      if (visited[now.x][now.y]) continue;
      visited[now.x][now.y] = true;

      for (int k = 0; k < 4; k++) {
        int nx = now.x + dx[k];
        int ny = now.y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < 501 && ny < 501) {
          int damage = map[nx][ny];
          if (damage != -1) {
            pq.offer(new Node(nx, ny, now.life + damage));
          }
        }
      }
    }

    System.out.print(-1);
  }
}
