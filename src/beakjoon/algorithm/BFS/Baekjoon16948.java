package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16948 {
  static int N, r1, c1, r2, c2;
  static boolean[][] chessboard;
  static int[] dx = {-2, -2, 0, 0, 2, 2};
  static int[] dy = {-1, 1, -2, 2, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    r1 = Integer.parseInt(st.nextToken());
    c1 = Integer.parseInt(st.nextToken());
    r2 = Integer.parseInt(st.nextToken());
    c2 = Integer.parseInt(st.nextToken());

    chessboard = new boolean[N][N];
    System.out.print(dfs(r1, c1));
  }

  private static int dfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y, 0});
    chessboard[x][y] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      if (now[0] == r2 && now[1] == c2) return now[2];

      for (int k = 0; k < dx.length; k++) {
        int nx = now[0] + dx[k];
        int ny = now[1] + dy[k];
        int count = now[2] + 1;

        if (nx < 0 || ny < 0 || nx >= N || ny >= N || chessboard[nx][ny]) continue;

        queue.add(new int[]{nx, ny, count});
        chessboard[nx][ny] = true;
      }
    }

    return -1;
  }
}
