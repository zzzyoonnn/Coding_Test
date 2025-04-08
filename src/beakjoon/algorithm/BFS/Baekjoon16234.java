package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16234 {
  static int N, L, R;
  static boolean changed;
  static int[][] A;
  static List<Position> list;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  private static class Position {
    int x, y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    A = new int[51][51];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }


    int result = 0;
    while (true) {
      changed = false;
      visited = new boolean[51][51];

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j]) {
            dfs(i, j);
          }
        }
      }

      if (!changed) break;

      result++;
    }
    System.out.print(result);
  }

  private static void dfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    list = new LinkedList<>();
    queue.offer(new int[]{x, y});
    list.add(new Position(x, y));
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int curX = cur[0];
      int curY = cur[1];

      for (int k = 0; k < 4; k++) {
        int nx = curX + dx[k];
        int ny = curY + dy[k];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

        int result = Math.abs(A[curX][curY] - A[nx][ny]);

        if (result >= L && result <= R && !visited[nx][ny]) {
          changed = true;
          visited[nx][ny] = true;
          queue.offer(new int[]{nx, ny});
          list.add(new Position(nx, ny));
        }
      }
    }

    int sum = 0;
    for (int i = 0; i < list.size(); i++) {
      Position p = list.get(i);
      sum += A[p.x][p.y];
    }

    int avg = sum / list.size();

    for (int i = 0; i < list.size(); i++) {
      Position p = list.get(i);

      A[p.x][p.y] = avg;
    }
  }
}
