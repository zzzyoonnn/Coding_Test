package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon13901 {
  static int r, c, k, startX, startY, dirIndex;
  static int[][] arr;
  static boolean[][] visited;
  static int[] dir = new int[4];
  static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    arr = new int[r][c];
    visited = new boolean[r][c];

    k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int kr = Integer.parseInt(st.nextToken());
      int kc = Integer.parseInt(st.nextToken());

      arr[kr][kc] = 2;
    }

    st = new StringTokenizer(br.readLine());
    startX = Integer.parseInt(st.nextToken());
    startY = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      dir[i] = Integer.parseInt(st.nextToken()) - 1;
    }
    bfs();

    System.out.print(startX + " " + startY);
  }

  private static void bfs() {
    Queue<int[]> queue = new LinkedList<int[]>();
    visited[startX][startY] = true;
    queue.offer(new int[] {startX, startY});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      for (int i = 0; i < 4; i++) {
        int index = dir[(dirIndex + i) % 4];
        int nx = cur[0] + dx[index];
        int ny = cur[1] + dy[index];

        if(nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] || arr[nx][ny] == 2) continue;

        visited[nx][ny] = true;
        queue.offer(new int[] {nx, ny});
        dirIndex = (dirIndex + i) % 4;
        startX = nx;
        startY = ny;
        break;
      }
    }
  }
}
