package beakjoon.algorithm.BFS;

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
  static int[][] result;

  private static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    visited = new boolean[n][m];
    result = new int[n][m];

    int startX = 0, startY = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < m; j++) {

        arr[i][j] = Integer.parseInt(st.nextToken());
        if (arr[i][j] == 2) {
          startX = i;
          startY = j;
        }
      }
    }

    bfs(startX, startY);
    result[startX][startY] = 0;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && arr[i][j] == 1) {
          sb.append(-1).append(' ');
        } else {
          sb.append(result[i][j]).append(' ');
        }
      }
      sb.append('\n');
    }
    System.out.print(sb);
  }

  private static void bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(x, y));

    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      int nowX = cur.x;
      int nowY = cur.y;

      for (int k = 0; k < 4; k++) {
        int nx = nowX + dx[k];
        int ny = nowY + dy[k];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
        if (arr[nx][ny] == 0) continue;
        if (visited[nx][ny]) continue;

        queue.offer(new Node(nx, ny));
        visited[nx][ny] = true;
        result[nx][ny] = result[nowX][nowY] + 1;
      }
    }
  }
}
