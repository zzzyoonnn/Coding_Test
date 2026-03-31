package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj3187 {
  static int r, c, sheep, wolf;
  static char[][] grid;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    grid = new char[r][c];
    visited = new boolean[r][c];

    for (int i = 0; i < r; i++) {
      grid[i] = br.readLine().toCharArray();
    }

    int totalSheep = 0;
    int totalWolf = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if ((grid[i][j] == 'v' || grid[i][j] == 'k') && !visited[i][j]) {
          sheep = 0;
          wolf = 0;
          dfs(i, j);

          if (sheep > wolf) totalSheep += sheep;
          else totalWolf += wolf;
        }
      }
    }

    System.out.print(totalSheep + " " + totalWolf);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    if (grid[x][y] == 'v') wolf++;
    if (grid[x][y] == 'k') sheep++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && !visited[nx][ny] && grid[nx][ny] != '#') {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < r && y >= 0 && y < c;
  }
}
