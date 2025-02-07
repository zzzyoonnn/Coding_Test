package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1261 {
  static char[][] map;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  private static class Position implements Comparable<Position> {
    int x;
    int y;
    int count;

    public Position(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }

    @Override
    public int compareTo(Position o) {
      return this.count - o.count;
    }
  }

  public static void main(String[] args) throws IOException {
    int[] mapData = setMap();

    int result = dijkstra(mapData[0], mapData[1]);
    System.out.print(result);
  }

  private static int dijkstra(int n, int m) {
    PriorityQueue<Position> pq = new PriorityQueue<>();
    pq.offer(new Position(0, 0, 0));
    boolean[][] visited = new boolean[n][m];

    while (!pq.isEmpty()) {
      Position now = pq.poll();

      if (now.x == n - 1 && now.y == m - 1) {
        return now.count;
      }

      if (visited[now.x][now.y]) continue;
      visited[now.x][now.y] = true;

      for (int k = 0; k < 4; k++) {
        int nx = now.x + dx[k];
        int ny = now.y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
          if (map[nx][ny] == '1') {
            pq.offer(new Position(nx, ny, now.count + 1));
          } else {
            pq.offer(new Position(nx, ny, now.count));
          }
        }
      }
    }
    return -1;
  }

  private static int[] setMap() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    map = new char[n][m];
    for (int i = 0; i < n; i++) {
      map[i] = br.readLine().toCharArray();
    }

    return new int[] {n, m};
  }
}
