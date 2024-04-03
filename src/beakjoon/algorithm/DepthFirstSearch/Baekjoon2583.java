package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2583 {
  static int n, m, k;
  static int count;
  static boolean[][] checked;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    n = Integer.parseInt(st.nextToken());       // width
    m = Integer.parseInt(st.nextToken());       // height
    k = Integer.parseInt(st.nextToken());       // 직사각형 개수

    checked = new boolean[n][m];

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());

      // 왼쪽 아래 꼭짓점
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());

      // 오른쪽 위 꼭짓점(-1)
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      for (int x = x1; x < x2; x++) {
        for (int y = y1; y < y2; y++) {
          checked[y][x] = true;         // 직사각형이 만들어지는 구역은 true로 변경
          // checked[y][x]임에 주의하자
        }
      }

    }

    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <m; j++) {
        if (!checked[i][j]) {     // 직사각형 구간도 아니고, 확인되지 않은 곳이라면
          count = 0;
          dfs(i, j);        // dfs 실행
          list.add(count);  // dfs 결과 list에 추가
        }
      }
    }

    Collections.sort(list);
    sb.append(list.size()).append('\n');

    for (int i : list) {
      sb.append(i).append(' ');
    }
    System.out.println(sb);
  }

  private static void dfs(int i, int j) {
    checked[i][j] = true;
    count++;

    for (int k = 0; k < 4; k++) {
      int x = i + dx[k];
      int y = j + dy[k];

      if (x >= 0 && y >= 0 && x < n && y < m) {
        if (!checked[x][y]) dfs(x, y);      // 직사각형 구간이 아니라면, dfs 실행
      }
    }
  }
}
