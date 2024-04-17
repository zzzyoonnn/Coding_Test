package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1012_1 {
  static int height, width;
  static boolean[][] arr;
  static boolean[][] check;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());        // 테스트 케이스의 개수

    for (int tc = 0; tc < t; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      width = Integer.parseInt(st.nextToken());       // 배추밭의 가로 길이
      height = Integer.parseInt(st.nextToken());      // 배추밭의 세로 길이
      int k = Integer.parseInt(st.nextToken());       // 배추가 심어져 있는 위치의 개수

      // 배추밭의 정보를 담을 boolean배열 초기화(메모리를 적게 사용하기 위해 boolean 사용)
      arr = new boolean[width][height];
      // 방문 확인할 boolean배열 초기화
      check = new boolean[width][height];

      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr[u][v] = true;     // 배추밭임을 표시
      }

      int count = 0;          // 배추밭의 개수 세기용
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
          if (arr[i][j] && !check[i][j]) {
            dfs(i, j);
            count++;        // 묶음 탐색 끝났으므로 count++;
          }
        }
      }

      System.out.println(count);
    }
  }

  private static void dfs(int i, int j) {
    check[i][j] = true;

    // 상하좌우 깊이우선탐색 시작
    for (int k = 0; k < 4; k++) {
      int x = i + dx[k];
      int y = j + dy[k];

      if (x >= 0 && y >= 0 && x < width && y < height) {
        if (arr[x][y] && !check[x][y]) dfs(x, y);
      }
    }
  }
}
