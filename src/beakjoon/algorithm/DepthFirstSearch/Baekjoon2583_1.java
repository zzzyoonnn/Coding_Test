package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2583_1 {
  static int n, m, area;
  static boolean[][] arr;
  static boolean[][] checked;
  static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());       // 세로(y)
    n = Integer.parseInt(st.nextToken());       // 가로(x)
    int k = Integer.parseInt(st.nextToken());   // 직사각형 개수

    arr = new boolean[m][n];
    checked = new boolean[m][n];

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());

      // 왼쪽 아래 점
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());

      // 오른쪽 위 점
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());


      for (int x = x1; x < x2; x++) {
        for (int y = y1; y < y2; y++) {
          arr[y][x] = true;
        }
      }
    }

    ArrayList<Integer> list = new ArrayList<>();
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!arr[i][j] && !checked[i][j]) {
          area = 0;
          dfs(i, j);
          count++;
          list.add(area);
        }
      }
    }

    System.out.println(count);

    Collections.sort(list);
    for (int i : list) {
      System.out.print(i + " ");
    }
  }

  private static void dfs(int x, int y) {
    checked[x][y] = true;
    area++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
        if (!arr[nx][ny] && !checked[nx][ny]) dfs(nx, ny);
      }
    }
  }
}
