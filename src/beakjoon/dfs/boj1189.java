package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1189 {
  static int r, c, k, result;
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    map = new char[r][c];
    visited = new boolean[r][c];
    for (int i = 0; i < r; i++) {
      map[i] = br.readLine().toCharArray();
    }

    result = 0;
    dfs(r - 1, 0, 1);

    System.out.print(result);
  }

  private static void dfs(int x, int y, int count) {
    if (count > k) return;
    visited[x][y] = true;

    if (x == 0 && y == c - 1) {
      if (count == k) result++;
      visited[x][y] = false;
      return;
    }

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && !visited[nx][ny] && map[nx][ny] == '.') {
        dfs(nx, ny, count + 1);
      }
    }
    visited[x][y] = false;
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < r && y >= 0 && y < c;
  }
}
