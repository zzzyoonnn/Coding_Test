package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1303 {
  static int n, m, count, wCount = 0, bCount = 0;
  static char[][] arr;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new char[m][n];
    visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      arr[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          count = 0;
          char c = arr[i][j];
          dfs(i, j, c);

          if (c == 'W') wCount += count * count;
          else if (c == 'B') bCount += count * count;
        }
      }
    }

    System.out.println(wCount + " " + bCount);

  }

  private static void dfs(int x, int y, char c) {
    visited[x][y] = true;
    count++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < m && ny < n && arr[nx][ny] == c && !visited[nx][ny]) {
        dfs(nx, ny, c);
      }
    }
  }
}
