package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1926 {
  static int n, m, area;
  static int[][] arr;
  static boolean[][] checked;
  static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};      // 상하좌우 이동용

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());       // 세로
    m = Integer.parseInt(st.nextToken());       // 가로

    arr = new int[n][m];
    checked = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;      // 그림의 개수
    int maxArea = 0;    // 가장 넓은 그림의 넓이
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 1 && !checked[i][j]) {     // 확인하지 못한 그림 발견했다면
          area = 0;
          dfs(i, j);        // dfs 실행
          count++;          // 그림 개수 + 1
          maxArea = Math.max(maxArea, area);    // 가장 넓은 그림의 넓이 갱신
        }
      }
    }

    System.out.println(count);
    System.out.println(maxArea);
  }

  private static void dfs(int x, int y) {       // dfs 실행
    checked[x][y] = true;
    area++;

    for (int k = 0; k < 4; k++) {
      // 상하좌우 이동
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
        if (arr[nx][ny] == 1 && !checked[nx][ny]) {
          dfs(nx, ny);
        }
      }
    }
  }
}
