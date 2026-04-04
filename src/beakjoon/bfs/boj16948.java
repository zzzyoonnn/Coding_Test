package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16948 {
  static int n, r1, c1, r2, c2;
  static int[][] board;
  static int[] dx = {-2, -2, 0, 0, 2, 2}, dy = {-1, 1, -2, 2, -1, 1};

  static class Pos {
    int x, y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(board[i], n + 1);
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    r1 = Integer.parseInt(st.nextToken());
    c1 = Integer.parseInt(st.nextToken());
    r2 = Integer.parseInt(st.nextToken());
    c2 = Integer.parseInt(st.nextToken());

    bfs(r1, c1);

    System.out.print(board[r2][c2] == n + 1 ? "-1" : board[r2][c2]);
  }

  private static void bfs(int startX, int startY) {
    board[startX][startY] = 0;
    Queue<Pos> queue = new LinkedList<>();
    queue.add(new Pos(startX, startY));

    while (!queue.isEmpty()) {
      Pos cur = queue.poll();

      if (cur.x == r2 && cur.y == c2) break;

      for (int k = 0; k < 6; k++) {
        int nx = cur.x + dx[k];
        int ny = cur.y + dy[k];

        if (isInBounds(nx, ny) && board[nx][ny] == n + 1) {
          board[nx][ny] = board[cur.x][cur.y] + 1;
          queue.add(new Pos(nx, ny));
        }
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }
}
