package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4963_1 {
  static int w, h;
  static int[][] map;
  static boolean[][] checked;
  static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1}, dy = {0, 0, -1, 1, -1, 1, -1, 1};      // 상하좌우 대각선 이동

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    while (true) {
      st = new StringTokenizer(br.readLine());

      w = Integer.parseInt(st.nextToken());         // 너비
      h = Integer.parseInt(st.nextToken());         // 높이

      if (h == 0 && w == 0) break;      // 입력 종료 조건

      map = new int[h][w];              // 지도 정보를 담은 배열
      checked = new boolean[h][w];      // 확인용 배열

      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < w; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int count = 0;        // 섬의 개수 세기용
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (!checked[i][j] && map[i][j] == 1) {       // 확인되지 않은 섬이라면
            dfs(i, j);      // dfs 실행
            count++;        // 섬의 개수 + 1;
          }
        }
      }
      System.out.println(count);
    }
  }

  private static void dfs(int x, int y) {
    checked[x][y] = true;           // 확인

    for (int k = 0; k < 8; k++) {
      // 상하좌우 대각선 이동
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
        if (!checked[nx][ny] && map[nx][ny] == 1) {     // 확인되지 않은 섬이라면
          dfs(nx, ny);                                  // dfs 실행
        }
      }
    }
  }
}
