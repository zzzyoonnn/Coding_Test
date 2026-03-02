package beakjoon.archive.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs
public class Baekjoon2178_1 {
  static int n, m, count;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s);

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      s = br.readLine();
      for (int j = 0; j < m; j++)
        arr[i][j] = s.charAt(j) - '0';
    }

    count = 0;
    dfs(0, 0, 1);

    System.out.print(min);
  }

  private static void dfs(int i, int j, int count) {
    if (i == n - 1 && j == m - 1) {
      min = Math.min(count, min);
    }

    visited[i][j] = true;

    for (int k = 0; k < 4; k++) {
      int nx = i + dx[k];
      int ny = j + dy[k];

      if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
        if (!visited[nx][ny] && arr[nx][ny] == 1) {
          dfs(nx, ny, count + 1);
        }
      }
    }

    visited[i][j] = false;
  }
}
