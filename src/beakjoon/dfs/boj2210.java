package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj2210 {
  static String[][] board;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
  static HashSet<String> result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    board = new String[5][5];

    StringTokenizer st;
    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < 5; j++) {
        board[i][j] = st.nextToken();
      }
    }

    result = new HashSet<>();
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        dfs(i, j, board[i][j]);
      }
    }

    System.out.print(result.size());
  }

  private static void dfs(int x, int y, String now) {

    if (now.length() == 6) {
      result.add(now);
      return;
    }

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny)) {
        dfs(nx, ny, now + board[nx][ny]);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < 5 && y >= 0 && y < 5;
  }
}
