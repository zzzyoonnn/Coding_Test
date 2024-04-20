package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14716 {
  static int m, n;
  static int[][] arr;
  static boolean[][] checked;
  static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1}, dy = {0, 0, -1, 1, -1, 1, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());       // 세로
    n = Integer.parseInt(st.nextToken());       // 가로

    arr = new int[m][n];
    checked = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;      // 현수막 글자의 개수
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] == 1 && !checked[i][j]) {
          dfs(i, j);
          count++;
        }
      }
    }

    System.out.println(count);
  }

  private static void dfs(int x, int y) {
    checked[x][y] = true;

    for (int k = 0; k < 8; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
        if (arr[nx][ny] == 1 && !checked[nx][ny]) {
          dfs(nx, ny);
        }
      }
    }
  }
}
