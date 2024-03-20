package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 간단하지만 귀찮은 영상처리 과제가 주어졌다. 
  과제의 명세는 다음과 같다.
  세로 길이가 N이고 가로 길이가 M인 화면은 총 N × M개의 픽셀로 구성되어 있고 
  (i, j)에 있는 픽셀은 R{i,j} (Red), G{i,j} (Green), B{i,j} (Blue) 3가지 색상의 의미를 담고 있다. 
  각 색상은 0이상 255이하인 값으로 표현 가능하다.
  모든 픽셀에서 세 가지 색상을 평균내어 경계값 T보다 크거나 같으면 픽셀의 값을 255로, 작으면 0으로 바꿔서 새로운 화면으로 저장한다.
  새로 만들어진 화면에서 값이 255인 픽셀은 물체로 인식한다. 
  값이 255인 픽셀들이 상하좌우로 인접해있다면 이 픽셀들은 같은 물체로 인식된다.
  화면에서 물체가 총 몇 개 있는지 구하는 프로그램을 작성하시오.
입력
- 화면의 세로 N, 가로 M 값이 공백으로 구분되어 주어진다.
  두 번째 줄부터 N + 1줄까지 i번째 가로를 구성하고 있는 픽셀의 R{i,j}, G{i,j}, B{i,j}의 값이 공백으로 구분되어 총 M개 주어진다.
  마지막 줄에는 경계값 T가 주어진다.
출력
- 화면에 있는 물체의 개수를 출력하라. 
  만약 물체가 없으면 0을 출력하면 된다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon21938 {
  static int n, m;
  static int[][] color;
  static int[][] pixel;
  static boolean[][] checked;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};      // 상하좌우 이동용

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());       // 세로 길이
    m = Integer.parseInt(st.nextToken());       // 가로 길이

    color = new int[n][m * 3];      // RGB값
    pixel = new int[n][m];              // 픽셀값
    checked =  new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int temp = 0;     // RGB값 계산용

      for (int j = 0; j < m * 3; j++) {
        color[i][j] = Integer.parseInt(st.nextToken());
        temp += color[i][j];            // RGB값 구하기 위해..

        if (j % 3 == 2) {               // RGB값 구하기
          pixel[i][j / 3] = temp;
          temp = 0;
        }
      }
    }

    int t = Integer.parseInt(br.readLine());    // 경계값

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int temp = pixel[i][j] / 3;         // RGB값과 경계값 비교용
        if (temp >= t) pixel[i][j] = 255;   // RGB값이 경계값보다 크거나 같다면 pixel값은 255
        else pixel[i][j] = 0;               // 그렇지 않다면 pixel값은 0
      }
    }

    int count = 0;      // 물체의 개수
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (pixel[i][j] == 255 && !checked[i][j]) {
          dfs(i, j);
          count++;
        }
      }
    }
    System.out.println(count);
  }

  private static void dfs(int i, int j) {
    checked[i][j] = true;

    for (int k = 0; k < 4; k++) {
      int x = i + dx[k];
      int y = j + dy[k];

      if (x >= 0 && y >= 0 && x < n && y < m) {
        if (pixel[x][y] == 255 && !checked[x][y]) {
          dfs(x, y);
        }
      }
    }
  }
}
