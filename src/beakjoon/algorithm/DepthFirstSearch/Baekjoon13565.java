package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13565 {
  static int n, m;
  static boolean check = false;
  static boolean[][] arr;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    arr = new boolean[m][n];
    visited = new boolean[m][n];

    String s;
    for (int i = 0; i < m; i++) {
      s = br.readLine();

      for (int j = 0; j < n; j++) {
        if (s.charAt(j) == '0') arr[i][j] = true;
      }
    }

    for (int i = 0; i < n; i++) {
      if (arr[0][i] && !visited[0][i]) dfs(0, i);
    }

    if (check) System.out.println("YES");
    else System.out.println("NO");

  }

  static void dfs(int x, int y) {
    visited[x][y] = true;

    if (x == m - 1) {
      check = true;
      return;
    }

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < m && ny < n && arr[nx][ny] && !visited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }
}
