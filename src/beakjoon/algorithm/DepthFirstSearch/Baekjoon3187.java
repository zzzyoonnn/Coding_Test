package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3187 {
  static int r, c, sheep, wolf;
  static char[][] arr;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    arr = new char[r][c];
    for (int i = 0; i < r; i++) {
      arr[i] = br.readLine().toCharArray();
    }

    visited = new boolean[r][c];

    int totalSheep = 0;
    int totalWolf = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (arr[i][j] != '#' && !visited[i][j]) {
          sheep = 0;
          wolf = 0;
          dfs(i, j);

          if (sheep == 0 && wolf == 0) continue;

          if (sheep > wolf) totalSheep += sheep;
          else totalWolf += wolf;
        }
      }
    }

    System.out.print(totalSheep + " " + totalWolf);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    if (arr[x][y] == 'k') sheep++;
    if (arr[x][y] == 'v') wolf++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny] && arr[nx][ny] != '#') {
        dfs(nx, ny);
      }
    }
  }
}
