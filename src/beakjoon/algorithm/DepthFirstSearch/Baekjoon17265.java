package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17265 {
  static int n, max, min;
  static char[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new char[n][n];

    max = Integer.MIN_VALUE / 2;
    min = Integer.MAX_VALUE / 2;

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        arr[i][j] = st.nextToken().charAt(0);
      }
    }

    dfs(0, 0, arr[0][0] - '0', '0');

    System.out.println(max + " " + min);
  }

  private static void dfs(int x, int y, int pre, char oper) {
    int now = arr[x][y] - '0';
    if (now >= 0 && now <= 5) {
      if (oper == '+') pre += now;
      else if (oper == '-') pre -= now;
      else if (oper == '*') pre *= now;
    } else {
      oper = arr[x][y];
    }

    if (x == n - 1 && y == n - 1) {
      max = Math.max(max, pre);
      min = Math.min(min, pre);
      return;
    }

    if (x < n - 1) dfs(x + 1, y, pre, oper);

    if (y < n - 1) dfs(x, y + 1, pre, oper);
  }
}
