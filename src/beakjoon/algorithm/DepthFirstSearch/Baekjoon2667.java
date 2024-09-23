package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon2667 {
  static int n, count;
  static char[][] arr;
  static boolean[][] visited;
  static ArrayList<Integer> list = new ArrayList<Integer>();
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    arr = new char[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] == '1' && !visited[i][j]) {
          count = 0;
          dfs(i, j);
          list.add(count);
        }
      }
    }
    System.out.println(list.size());
    Collections.sort(list);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  public static void dfs(int x, int y) {
    visited[x][y] = true;
    count++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && arr[nx][ny] == '1') {
        dfs(nx, ny);
      }
    }
  }
}
