package beakjoon.archive.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs
public class Baekjoon2178_2 {
  static int n, m, count;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

  static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s);

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      s = br.readLine();
      for (int j = 0; j < m; j++)
        arr[i][j] = s.charAt(j) - '0';
    }

    bfs(0, 0);

    System.out.print(arr[n - 1][m - 1]);
  }

  private static void bfs(int i, int j) {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(i, j));
    visited[i][j] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = cur.x + dx[k];
        int ny = cur.y + dy[k];


        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
          if (!visited[nx][ny] && arr[nx][ny] == 1) {
            visited[nx][ny] = true;
            arr[nx][ny] = arr[cur.x][cur.y] + 1;
            q.add(new Node(nx, ny));
          }
        }
      }
    }
  }
}
