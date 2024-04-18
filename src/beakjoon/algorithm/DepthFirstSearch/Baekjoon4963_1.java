package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4963_1 {
  static int w, h;
  static int[][] arr;
  static boolean[][] checked;
  static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1}, dy = {0, 0, -1, 1, -1, 1, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s;
    StringTokenizer st;
    while (true) {
      st = new StringTokenizer(br.readLine());

      w = Integer.parseInt(st.nextToken());         // 너비
      h = Integer.parseInt(st.nextToken());         // 높이

      if (w == 0 && h == 0) break;

      arr = new int[w][h];
      checked = new boolean[w][h];

      for (int i = 0; i < w; i++) {
        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < h; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int count = 0;        // 섬의 개수 세기용
      for (int i = 0; i < w; i++) {
        for (int j = 0; j < h; j++) {
          if (!checked[i][j]) {
            dfs(i, j);
            count++;
          }
        }
      }
    }
  }

  private static void dfs(int i, int j) {
    checked[i][j] = true;

    for (int k = 0; k < 8; k++) {
      // 상하좌우 대각선 이동
      int x = i + dx[k];
      int y = j + dy[k];

      if (x >= 0 && y >= 0 && x < w && y < h) {
        if (!checked[x][y]) {
          dfs(x, y);
        }
      }
    }
  }
}
