package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon14497 {
  static int N, M, x1, y1, x2, y2;
  static char[][] map;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  private static class Position implements Comparable<Position> {
    int x;
    int y;
    int count;

    public Position (int x, int y, int count) {
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
    inputData();

    dijkstra();
  }

  private static void dijkstra() {
    PriorityQueue<Position> pq = new PriorityQueue<>();
    pq.offer(new Position(x1, y1, 0));
    boolean[][] visited = new boolean[N][M];

    while (!pq.isEmpty()) {
      Position now = pq.poll();

      if (now.x == x2 && now.y == y2) {
        System.out.print(now.count);
        break;
      }

      if (visited[now.x][now.y]) continue;

      visited[now.x][now.y] = true;

      for (int k = 0; k < 4; k++) {
        int nx = now.x + dx[k];
        int ny = now.y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          // 한번 점프하면 파동으로 모두 쓰러짐
          if (map[nx][ny] == '0') {
            pq.offer(new Position(nx, ny, now.count));
          } else {
            pq.offer(new Position(nx, ny, now.count + 1));
          }
        }
      }
    }
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    // Junan's location
    x1 = Integer.parseInt(st.nextToken()) - 1;
    y1 = Integer.parseInt(st.nextToken()) - 1;

    // suspect's location
    x2 = Integer.parseInt(st.nextToken()) - 1;
    y2 = Integer.parseInt(st.nextToken()) - 1;

    String s;
    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      s = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = s.charAt(j);
      }
    }
  }
}
