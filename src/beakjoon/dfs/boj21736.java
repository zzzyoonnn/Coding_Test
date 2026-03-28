package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21736 {
  static int n, m, count;
  static char[][] campus;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    int x = 0, y = 0;
    count = 0;
    String s;
    campus = new char[n][m];
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      s = br.readLine();

      for (int j = 0; j < m; j++) {
        campus[i][j] = s.charAt(j);

        if (campus[i][j] == 'I') {
          x = i;
          y = j;
        }
      }
    }

    dfs(x, y);

    System.out.print(count == 0 ? "TT" : count);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;

    if (campus[x][y] == 'P') count++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && !visited[nx][ny] && campus[nx][ny] != 'X') dfs(nx, ny);
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }
}
