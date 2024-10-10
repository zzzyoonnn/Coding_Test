package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3184 {
  static int r, c, sheep = 0, wolf = 0;
  static char[][] arr;
  static boolean[][] checked;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());   // row
    c = Integer.parseInt(st.nextToken());   // column

    arr = new char[r][c];
    checked = new boolean[r][c];
    for (int i = 0; i < r; i++) {
      arr[i] = br.readLine().toCharArray();
    }

    int totalSheep = 0, totalWolf = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (arr[i][j] != '#' && !checked[i][j]) {
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
    checked[x][y] = true;

    if (arr[x][y] == 'o') sheep++;
    if (arr[x][y] == 'v') wolf++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < r && ny < c && !checked[nx][ny] && arr[nx][ny] != '#') {
        dfs(nx, ny);
      }
    }
  }
}
