package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon13549 {
  static int n, k;
  static int[] dx = {-1, 1};
  static boolean[] visited = new boolean[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());   // subin's position
    k = Integer.parseInt(st.nextToken());   // brother's position

    System.out.println(bfs(n, k));
  }

  private static int bfs(int start, int destination) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{start, 0});
    visited[start] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int pos = now[0];
      int move = now[1];

      if (pos == destination) {
        return move;
      }

      int jump = pos * 2;
      if (jump < visited.length && !visited[jump]) {
        visited[jump] = true;
        queue.add(new int[]{jump, move});
      }

      for (int k = 0; k < dx.length; k++) {
        int next = pos + dx[k];
        if (next >= 0 && next < visited.length && !visited[next]) {
          visited[next] = true;
          queue.add(new int[]{next, move + 1});
        }
      }
    }

    return -1;
  }
}
