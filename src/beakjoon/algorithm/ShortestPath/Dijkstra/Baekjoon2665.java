package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2665 {
  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  private static class Node implements Comparable<Node> {
    int x;
    int y;
    int cost;

    public Node (int x, int y, int cost) {
      this.x = x;
      this.y = y;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());    // 한 줄에 들어가는 방의 개수

    initialize();

    String s;
    for (int i = 0; i <N; i++) {
      s = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = s.charAt(j) - '0';
      }
    }

    dijkstra();
  }

  private static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(0, 0, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (now.x == N - 1 && now.y == N - 1) {
        System.out.print(now.cost);
        break;
      }

      if (visited[now.x][now.y]) continue;
      visited[now.x][now.y] = true;

      for (int k = 0; k < 4; k++) {
        int nx = now.x + dx[k];
        int ny = now.y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
          int nextCost = now.cost + ((map[nx][ny] == 0) ? 1 : 0);
          pq.offer(new Node(nx, ny, nextCost));
        }
      }
    }
  }

  private static void initialize() {
    map = new int[N][N];
    visited = new boolean[N][N];
  }
}
