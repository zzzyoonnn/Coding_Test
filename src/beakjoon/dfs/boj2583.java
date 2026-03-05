package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj2583 {
  static int m, n, size;
  static boolean[][] map;
  static ArrayList<Integer> sizes;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    map = new boolean[m][n];

    int k = Integer.parseInt(st.nextToken());
    int startX, startY, endX, endY;
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      startX = Integer.parseInt(st.nextToken());
      startY = Integer.parseInt(st.nextToken());
      endX = Integer.parseInt(st.nextToken());
      endY = Integer.parseInt(st.nextToken());

      for (int a = startX; a < endX; a++) {
        for (int b = startY; b < endY; b++) {
          map[b][a] = true;
        }
      }
    }
    int count = 0;
    sizes = new ArrayList<>();
    for (int a = 0; a < m; a++) {
      for (int b = 0; b < n; b++) {
        if (!map[a][b]) {
          count++;
          size = 0;
          dfs(a, b);
          sizes.add(size);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(count).append('\n');

    Collections.sort(sizes);
    for (int size : sizes) sb.append(size).append(' ');

    System.out.print(sb);
  }

  private static void dfs(int x, int y) {
    map[x][y] = true;
    size++;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (isInBounds(nx, ny) && !map[nx][ny]) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }
}
