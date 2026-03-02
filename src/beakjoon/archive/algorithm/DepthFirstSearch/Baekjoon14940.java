package beakjoon.archive.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon14940 {
  static int n, m;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    visited = new boolean[n][m];

    int startX = 0;
    int startY = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());

        if (arr[i][j] == 2) {
          startX = i;
          startY = j;
        }
        if (arr[i][j] == 1) arr[i][j] = -1;
      }
    }
    arr[startX][startY] = 0;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{startX, startY});

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int nowX = now[0];
      int nowY = now[1];

      for (int k = 0; k < 4; k++) {
        int nx = nowX + dx[k];
        int ny = nowY + dy[k];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && arr[nx][ny] != 0) {
          arr[nx][ny] = arr[nowX][nowY] + 1;
          visited[nx][ny] = true;
          q.offer(new int[]{nx, ny});
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(arr[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
