package beakjoon.archive.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1012_2 {
  static int m, n, c;
  static int[][] farm;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int t = 0; t < tc; t++) {
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      farm = new int[m][n];
      visited = new boolean[m][n];

      for (int i = 0; i < c; i++) {
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        farm[x][y] = 1;
      }

      int count = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (farm[i][j] == 1 && !visited[i][j]) {
            count++;
            dfs(i, j);
          }
        }
      }

      System.out.println(count);
    }
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < m && ny < n && farm[nx][ny] == 1 && !visited[nx][ny]) {
        visited[nx][ny] = true;
        dfs(nx, ny);
      }
    }
  }
}
