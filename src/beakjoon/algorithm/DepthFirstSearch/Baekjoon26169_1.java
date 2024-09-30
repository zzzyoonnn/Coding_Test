package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon26169_1 {
  static int x, y, count = 0, result = 0;
  static int[][] arr;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    arr = new int[5][5];

    StringTokenizer st;
    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    backTracking(x, y, 0, 0);

    System.out.println(result);
  }

  private static void backTracking(int x, int y, int depth, int count) {
    if (arr[x][y] == 1) count++;

    if (depth == 3) {
      if (count >= 2) {
        result = 1;
      }

      return;
    }

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || arr[nx][ny] == -1) {
        continue;
      }

      arr[x][y] = -1;
      backTracking(nx, ny, depth + 1, count);
      arr[x][y] = 0;
    }
  }
}
