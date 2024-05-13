package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4396 {
  static int n, count;
  static char[][] arr;
  static char[][] result;
  static int dx[] = {1, -1, 0, 0, -1, -1, 1, 1};
  static int dy[] = {0, 0, -1, 1, -1, 1, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());        // 지뢰찾기 격자 크기
    arr = new char[n][n];

    String s;
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      for (int j = 0; j < n; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    boolean check = false;      // 지뢰 발견 확인용
    result = new char[n][n];
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      for (int j = 0; j < n; j++) {
        if (s.charAt(j) == 'x') {                   // 클릭했을 때
          if (arr[i][j] == '*') check = true;       // 지뢰 발견
          else {            // 클릭했는데 지뢰를 발견하지 못했다면
            count = 0;
            dfs(i, j);      // 인접한 방향에 지뢰가 있는지 확인
            result[i][j] = (char)(count + '0');            
          }
        }
        else if (s.charAt(j) == '.') {          // 클릭 안했다면
          result[i][j] = '.';                   // '.' 표시
        }
      }
    }

    if (check) {        // 지뢰를 발견했다면
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (arr[i][j] == '*') result[i][j] = '*';     // 지뢰가 있는 모든 칸 '*'로 표시
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(result[i][j]);
      }
      System.out.println();
    }
  }

  public static void dfs(int x, int y) {
    for (int k = 0; k < 8; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      // 범위 체크
      if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
        if(arr[nx][ny] == '*') {    // 주변에 지뢰가 있다면
          count++;                  // count++;
        }
      }
    }
  }
}
