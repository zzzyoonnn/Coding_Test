package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17300 {
  static int now, next;
  static StringTokenizer st;
  static int[][] number = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  static boolean[][] visited = new boolean[3][3];
  static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
  static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int l = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    now = Integer.parseInt(st.nextToken());
    int x = (now - 1) / 3;
    int y = (now + 2) % 3;
    next = Integer.parseInt(st.nextToken());

    dfs(x, y);

    if (st.hasMoreTokens()) System.out.println("NO");
    else System.out.println("YES");
  }

  static void dfs(int x, int y) {
    visited[x][y] = true;
    System.out.println(number[x][y] + " " + visited[x][y]);

    System.out.println(now + " " + next);

    for (int k = 0; k < 8; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
        if (number[nx][ny] == next && !visited[nx][ny]) {
          System.out.println(number[nx][ny] + " " + visited[nx][ny]);

          now = next;
          if (!st.hasMoreTokens()) {
            next = Integer.parseInt(st.nextToken());
            dfs(nx, ny);
          }
        }
      }
    }
  }
}
