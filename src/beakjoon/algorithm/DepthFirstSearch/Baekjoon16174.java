package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16174 {
  static int n;
  static boolean check = false;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {1, 0}, dy = {0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    visited = new boolean[n][n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0);

    if (check) System.out.print("HaruHaru");
    else System.out.print("Hing");
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    if (arr[x][y] == -1) {
      check = true;
      return;
    }

    for (int k = 0; k < 2; k++) {
      int nx = x + (dx[k] * arr[x][y]);
      int ny = y + (dy[k] * arr[x][y]);

      if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }
}
