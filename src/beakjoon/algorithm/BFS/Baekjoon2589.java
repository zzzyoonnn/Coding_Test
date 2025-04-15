package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2589 {
  static int H, W;
  static char[][] map;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());

    map = new char[H][W];

    for (int i = 0; i < H; i++) {
      map[i] = br.readLine().toCharArray();
    }

    int max = 0;
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        if (map[i][j] == 'L') {
          max = Math.max(max, treasureHunt(i, j));
        }
      }
    }

    System.out.print(max);
  }

  private static int treasureHunt(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[H][W];
    queue.offer(new int[]{x, y, 0});
    visited[x][y] = true;

    int maxDir = 0;
    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      int nowX = now[0];
      int nowY = now[1];
      int nowDir = now[2];

      for (int k = 0; k < 4; k++) {
        int nx = nowX + dx[k];
        int ny = nowY + dy[k];
        int nDir = nowDir + 1;

        if (isOutOfBounds(nx, ny)) continue;
        if (visited[nx][ny]) continue;
        if (map[nx][ny] == 'W') continue;

        queue.offer(new int[]{nx, ny, nDir});
        maxDir = Math.max(maxDir, nDir);
        visited[nx][ny] = true;
      }

    }
    return maxDir;

  }

  static boolean isOutOfBounds(int x, int y) {
    return x < 0 || y < 0 || x >= H || y >= W;
  }
}
