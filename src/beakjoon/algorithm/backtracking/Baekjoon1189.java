package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1189 {
  static int r, c, k, count = 0;
  static char[][] arr;
  static boolean[][] visited;
  static List<Integer> list;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new char[r][c];
    visited = new boolean[r][c];

    for (int i = 0; i < r; i++) {
      arr[i] = br.readLine().toCharArray();
    }

    visited[r - 1][0] = true;
    backTracking(r - 1, 0, 1);

    System.out.println(count);
  }

  private static void backTracking(int x, int y, int depth) {
    if (x == 0 && y == c - 1) {
      if (depth == k) {
        count++;
      }
      return;
    }


    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];

      if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] || arr[nx][ny] == 'T') {
        continue;
      }

      visited[nx][ny] = true;
      backTracking(nx, ny, depth + 1);
      visited[nx][ny] = false;
    }
  }
}
