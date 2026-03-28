package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj3184 {
  static int r, c, sheep, wolf;
  static char[][] yard;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    yard = new char[r][c];
    visited = new boolean[r][c];
    for (int i = 0; i < r; i++) {
      yard[i] = br.readLine().toCharArray();
    }

    int morningSheep = 0;
    int morningWolf = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (yard[i][j] != '#' && !visited[i][j]) {
          sheep = 0;
          wolf = 0;
          dfs(i, j);
          if (sheep > wolf) morningSheep += sheep;
          else morningWolf += wolf;
        }
      }
    }

    System.out.print(morningSheep + " " + morningWolf);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    if (yard[x][y] == 'o') sheep++;
    if (yard[x][y] == 'v') wolf++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && !visited[nx][ny] && yard[nx][ny] != '#') {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < r && y >= 0 && y < c;
  }
}
