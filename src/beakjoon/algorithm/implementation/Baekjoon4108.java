package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4108 {
  static int r, c, count;
  static char[][] arr;
  static char[][] result;
  static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
  static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());

      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      if (r == 0 && c == 0) break;      // "0 0"이 입력되면 종료

      // R X C개의 칸으로 이루어진 지뢰밭 입력받기
      // Input Reading: O(r * c)
      arr = new char[r][c];

      for (int i = 0; i < r; i++) {
        arr[i] = br.readLine().toCharArray();   // O(c)
      }

      // 인접해 있는 지뢰의 개수를 저장할 result 배열 생성
      result = new char[r][c];
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          count = 0;

          if (arr[i][j] == '*') {   // 지뢰칸은 그대로 출력
            result[i][j] = '*';
          } else {                  // 지뢰가 없는 칸은 인접해 있는 지뢰의 갯수 출력
            dfs(i, j);              // O(1) operation for each cell
            result[i][j] = (char)(count + '0');
          }
        }
      }

      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          System.out.print(result[i][j]);
        }
        System.out.println();
      }
    }
  }

  //dfs를 이용하여 상, 하, 좌, 우, 대각선에 인접해있는 지뢰의 개수 구하기
  //Time complexity of dfs is O(1) for each cell
  public static void dfs(int x, int y) {
    for (int k = 0; k < 8; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
        if (arr[nx][ny] == '*') count++; 
      }
    }
  }
}
