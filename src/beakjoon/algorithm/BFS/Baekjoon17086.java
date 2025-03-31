package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon17086 {
  static int N, M;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
  static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int max = -1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] == 1) continue;

        max = Math.max(max, dfs(i, j));
      }
    }

    System.out.print(max);
  }

  private static int dfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    visited = new boolean[N][M];
    visited[x][y] = true;
    queue.add(new int[]{x, y, 0});

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      for (int k = 0; k < 8; k++) {
        int nx = now[0] + dx[k];
        int ny = now[1] + dy[k];
        int count = now[2] + 1;

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if (visited[nx][ny]) continue;

        if (arr[nx][ny] == 1) return count;

        queue.offer(new int[]{nx, ny, count});
        visited[nx][ny] = true;
      }
    }
    return 0;
  }
}
