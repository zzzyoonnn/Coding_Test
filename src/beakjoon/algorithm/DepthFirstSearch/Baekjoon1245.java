package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1245 {
  static int N, M, count;
  static int[][] arr;
  static boolean isPeak;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1}, dy = {0, 0, 1, -1, -1, 1, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          isPeak = true;
          dfs(i, j);
          if (isPeak) count++;
        }
      }
    }

    System.out.print(count);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int k = 0; k < 8; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isIn(nx, ny)) {
        if (arr[x][y] < arr[nx][ny]) {
          isPeak = false;
        }

        if (!visited[nx][ny] && arr[x][y] == arr[nx][ny]) dfs(nx, ny);
      }
    }
  }

  private static boolean isIn(int nx, int ny) {
    return nx >= 0 && ny >= 0 && nx < N && ny < M;
  }
}
