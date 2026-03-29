package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7562 {
  static int l, startX, startY, endX, endY;
  static int[][] board;
  static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1}, dy = {2, 1, -1, -2, -2, -1, 1, 2};

  static class Knight {
    int x, y;

    Knight(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < t; tc++) {
      l = Integer.parseInt(br.readLine());
      board = new int[l][l];
      for (int i = 0; i < l; i++) {
        Arrays.fill(board[i], -1);
      }

      st = new StringTokenizer(br.readLine());
      startX = Integer.parseInt(st.nextToken());
      startY = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      endX = Integer.parseInt(st.nextToken());
      endY = Integer.parseInt(st.nextToken());

      dfs(startX, startY);
      sb.append(board[endX][endY]).append('\n');
    }

    System.out.print(sb);
  }

  private static void dfs(int x, int y) {
    board[x][y] = 0;
    Queue<Knight> queue = new LinkedList<>();
    queue.add(new Knight(x, y));

    while (!queue.isEmpty()) {
      Knight cur = queue.poll();

      if (cur.x == endX && cur.y == endY) return;

      for (int k = 0; k < 8; k++) {
        int nx = cur.x + dx[k];
        int ny = cur.y + dy[k];

        if (isInBounds(nx, ny) && board[nx][ny] == -1) {
          board[nx][ny] = board[cur.x][cur.y] + 1;
          queue.add(new Knight(nx, ny));
        }
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < l && y >= 0 && y < l;
  }
}
