package beakjoon.archive.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2583_2 {
  static int n, m, k;
  static boolean[][] arr;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static ArrayList<Integer> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new boolean[m][n];
    visited = new boolean[m][n];
    list = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int startX = Integer.parseInt(st.nextToken());
      int startY = Integer.parseInt(st.nextToken());
      int endX = Integer.parseInt(st.nextToken());
      int endY = Integer.parseInt(st.nextToken());

      for (int y = startY; y < endY; y++) {
        for (int x = startX; x < endX; x++) {
          arr[y][x] = true;
        }
      }
    }


    int size = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!arr[i][j] && !visited[i][j]) {
          size = dfs(i, j);
          list.add(size);
        }
      }
    }

    System.out.println(list.size());
    Collections.sort(list);
    for (int i : list) {
      System.out.print(i + " ");
    }
  }

  private static int dfs(int y, int x) {
    visited[y][x] = true;
    int size = 1;

    for (int k = 0; k < 4; k++) {
      int ny = y + dy[k];
      int nx = x + dx[k];

      if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[ny][nx] && !arr[ny][nx]) {
      visited[ny][nx] = true;
        size += dfs(ny, nx);
      }
    }
    return size;
  }
}
