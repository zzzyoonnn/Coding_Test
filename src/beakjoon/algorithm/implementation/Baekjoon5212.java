package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5212 {
  static int r, c;
  static char[][] arr, answer;
  static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    // 다도해 지도
    arr = new char[r][c];

    // 지도 정보 입력
    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      for (int j = 0; j < c; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    // 50년 뒤 지도
    answer = new char[r][c];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (arr[i][j] == 'X') dfs(i, j);
        else answer[i][j] = '.';
      }
    }

    // 50년 뒤 섬이 있는 지도 구역 구하기
    int startX = Integer.MAX_VALUE;
    int endX = -1;
    int startY = Integer.MAX_VALUE;
    int endY = -1;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (answer[i][j] == 'X') {
          startX = Math.min(i, startX);
          endX = Math.max(i, endX);

          startY = Math.min(j, startY);
          endY = Math.max(j, endY);
        }
      }
    }

    // 50년 뒤 지도 출력하기
    for (int i = startX; i <= endX; i++) {
      for (int j = startY; j <= endY; j++) {
        System.out.print(answer[i][j]);
      }
      System.out.println();
    }
  }

  public static void dfs(int x, int y) {
    int count = 0;

    // 인접한 칸들의 정보 확인
    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < r && ny < c) {     // 지도 범위 내라면
        if (arr[nx][ny] == '.') count++;                // 바다라면 count++;
      } else {      // 지도의 범위를 벗어난다면
        count++;    // count++;
      }
    }

    // 인접한 3칸 이상이 바다라면 잠긴다.
    if (count >= 3) answer[x][y] = '.';
    else answer[x][y] = 'X';
  }
}
