package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon6087 {
  static int W, H;
  static int[][] count;
  static char[][] map;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  private static class Position implements Comparable<Position> {
    int x;
    int y;
    int dir;
    int cnt;

    public Position(int x, int y, int dir, int cnt) {
      this.x = x;
      this.y = y;
      this.dir = dir;
      this.cnt = cnt;
    }

    @Override
    public int compareTo(Position o) {
      return this.cnt - o.cnt;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    count = new int[H][W];
    map = new char[H][W];

    final int INF = Integer.MAX_VALUE / 2;
    for (int i = 0; i < H; i++) {
    }

    int startX = 0, startY = 0;
    for (int i = 0; i < H; i++) {
      String s = br.readLine();
      Arrays.fill(count[i], INF);

      for (int j = 0; j < W; j++) {
        map[i][j] = s.charAt(j);

        if (map[i][j] == 'C') {
          startX = i;
          startY = j;
        }
      }
    }

    System.out.print(dijkstra(startX, startY));

  }

  private static int dijkstra(int startX, int startY) {
    PriorityQueue<Position> pq = new PriorityQueue<>();
    pq.add(new Position(startX, startY, -1, 0));
    count[startX][startY] = 0;

    int cnt = 0;

    while (!pq.isEmpty()) {
      Position now = pq.poll();

      if (map[now.x][now.y] == 'C') {
        cnt++;

        if (cnt == 2) {
          System.out.print(count[now.x][now.y]);
          System.exit(0);
        }
      }

      for (int k = 0; k < 4; k++) {
        int nx = now.x + dx[k];
        int ny = now.y + dy[k];


        if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
          if (map[nx][ny] == '*') continue;

          if (k != now.dir && now.dir != -1) {
            if (count[nx][ny] >= count[now.x][now.y] + 1) {
              count[nx][ny] = count[now.x][now.y] + 1;
              pq.add(new Position(nx, ny, k, now.cnt + 1));
            }
          } else {
            if (count[nx][ny] >= now.cnt) {
              count[nx][ny] = now.cnt;
              pq.add(new Position(nx, ny, k, now.cnt));
            }
          }
        }
      }
    }

    return -1;
  }
}
