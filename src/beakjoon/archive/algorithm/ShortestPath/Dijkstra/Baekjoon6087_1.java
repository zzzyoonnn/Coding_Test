package beakjoon.archive.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon6087_1 {
  static int w, h;
  static char[][] map;
  static int[][][] arr;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int INF = Integer.MAX_VALUE / 2;

  private static class Lazer implements Comparable<Lazer> {
    int x;
    int y;
    int dir;
    int count;

    public Lazer(int x, int y, int dir, int count) {
      this.x = x;
      this.y = y;
      this.dir = dir;
      this.count = count;
    }

    @Override
    public int compareTo(Lazer o) {
      return this.count - o.count;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    map = new char[h][w];
    arr = new int[h][w][4];

    String s;
    int index = 0;
    int[][] posC = new int[2][2];
    for (int i = 0; i < h; i++) {
      s = br.readLine();

      for (int j = 0; j < w; j++) {
        Arrays.fill(arr[i][j], INF);
        map[i][j] = s.charAt(j);

        if (map[i][j] == 'C') {
          posC[index][0] = i;
          posC[index][1] = j;
          index++;
        }
      }
    }

    int result = dijkstra(posC[0][0], posC[0][1], posC[1][0], posC[1][1]);

    System.out.print(result);
  }

  private static int dijkstra(int startX, int startY, int endX, int endY) {
    PriorityQueue<Lazer> pq = new PriorityQueue<>();

    for (int d = 0; d < 4; d++) {
      arr[startX][startY][d] = 0;
      pq.offer(new Lazer(startX, startY, d, 0));
    }

    while (!pq.isEmpty()) {
      Lazer cur = pq.poll();

      if (cur.x == endX && cur.y == endY) {
        return cur.count;
      }

      for (int k = 0; k < 4; k++) {
        int nx = cur.x + dx[k];
        int ny = cur.y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < h && ny < w && map[nx][ny] != '*') {
          int nextCount = cur.count + ((k == cur.dir) ? 0 :  1);

          if (arr[nx][ny][k] > nextCount) {
            arr[nx][ny][k] = nextCount;
            pq.offer(new Lazer(nx, ny, k, nextCount));
          }
        }
      }
    }

    return -1;
  }
}
