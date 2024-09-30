package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10026 {
  static int n, RCount, GCount, BCount, notBCount;
  static char[][] arr;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    arr = new char[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine().toCharArray();
    }

    // Count color sections
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          switch(arr[i][j]) {
            case 'R':
              dfs(i, j, 'R');
              RCount++;
              break;
            case 'G':
              dfs(i, j, 'G');
              GCount++;
              break;
            case 'B':
              dfs(i, j, 'B');
              BCount++;
              break;
          }
        }
      }
    }

    // Red-Green
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          if (arr[i][j] == 'B') {
            dfs(i, j, 'B');
          } else {
            dfs2(i, j);
            notBCount++;
          }
        }
      }
    }

    System.out.println((RCount + GCount + BCount) + " " + (notBCount + BCount));

  }

  // R, G, B count
  private static void dfs(int x, int y, char color) {
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && arr[nx][ny] == color) {
        dfs(nx, ny, color);
      }
    }
  }

  private static void dfs2(int x, int y) {
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && arr[nx][ny] != 'B') {
        dfs2(nx, ny);
      }
    }
  }
}
