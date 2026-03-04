package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj2667 {
  static int n, count;
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
  static ArrayList<Integer> result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new char[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      map[i] = br.readLine().toCharArray();
    }

    result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == '1' && !visited[i][j]) {
          count = 1;
          dfs(i, j);

          result.add(count);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(result.size()).append("\n");

    Collections.sort(result);
    for (int i : result) {
      sb.append(i).append("\n");
    }

    System.out.print(sb);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && map[nx][ny] == '1' && !visited[nx][ny]) {
        count++;
        dfs(nx, ny);
      }

    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }
}
