package beakjoon.archive.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1261_1 {
  static int n, m;
  static boolean[][] miro;
  static int[][] map;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int INF = Integer.MAX_VALUE / 2;

  private static class Position implements Comparable<Position> {
    int x;
    int y;
    int cost;

    public Position(int x, int y, int cost) {
      this.x = x;
      this.y = y;
      this.cost = cost;
    }

    @Override
    public int compareTo (Position p) {
      return this.cost - p.cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    miro = new boolean[n][m];
    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      Arrays.fill(map[i], INF);
    }

    String s;
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      for (int j = 0; j < m; j++) {
        if (s.charAt(j) == '1') miro[i][j] = true;
      }
    }

    dijkstra(0, 0);

    System.out.print(map[n - 1][m - 1]);
  }

  private static void dijkstra(int x, int y) {
    PriorityQueue<Position> q = new PriorityQueue<>();
    q.add(new Position(x, y, 0));
    map[x][y] = 0;

    while (!q.isEmpty()) {
      Position p = q.poll();

      if (p.x == n - 1 && p.y == m - 1) break;

      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k];
        int ny = p.y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {

          int cost = map[p.x][p.y] + (miro[nx][ny] ? 1 : 0);
          if (cost < map[nx][ny]) {
            map[nx][ny] = cost;
            q.add(new Position(nx, ny, cost));
          }
        }
      }
    }
  }
}
