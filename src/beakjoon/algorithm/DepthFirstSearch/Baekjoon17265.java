package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17265 {
  static int n, result;
  static char[][] arr;
  static boolean[][] visited;
  static int[] dx = {0, 1}, dy = {1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new char[n][n];
    visited = new boolean[n][n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        arr[i][j] = st.nextToken().charAt(0);
      }
    }

    dfs(0, 0, '0');

    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void dfs(int x, int y, char oper) {
    visited[x][y] = true;

    char now = arr[x][y];
    switch (now) {
      case '+':
        dfs()
    }


    for (int k = 0; k < 2; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }
}
