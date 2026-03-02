package beakjoon.archive.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1926_1 {
  static int n, m, count, max;
  static int[][] painting;
  static boolean[][] checked;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    painting = new int[n][m];
    checked = new boolean[n][m];
    count = 0;
    max = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        painting[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (painting[i][j] == 1 && !checked[i][j]) {
          count++;
          int temp = dfs(i, j);
          max = Math.max(temp, max);
        }
      }
    }

    System.out.println(count);
    System.out.print(max);
  }

  private static int dfs(int x, int y) {
    checked[x][y] = true;
    int size = 1;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < n && ny < m && !checked[nx][ny] && painting[nx][ny] == 1) {
        size += dfs(nx, ny);
      }
    }

    return size;
  }
}
