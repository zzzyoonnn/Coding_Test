package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon12761 {
  static int a, b, n, m;
  static int[] visited = new int[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());   // sky-kongkong's power
    b = Integer.parseInt(st.nextToken());   // sky-kongkong's power
    n = Integer.parseInt(st.nextToken());   // dongyu's position
    m = Integer.parseInt(st.nextToken());   // jumi's position

    System.out.println(dfs(n));
  }

  private static int dfs(int n) {

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(n);
    int now = n;
    visited[n] = 0;

    while (!queue.isEmpty()) {
      now = queue.poll();

      if (now == m) {
        return visited[now];
      }

      if (now + 1 < visited.length && visited[now + 1] == 0) {
        visited[now + 1] = visited[now] + 1;
        queue.offer(now + 1);
      }

      if (now - 1 >= 0 && visited[now - 1] == 0) {
        visited[now - 1] = visited[now] + 1;
        queue.offer(now - 1);
      }

      if (now + a < visited.length && visited[now + a] == 0) {
        visited[now + a] = visited[now] + 1;
        queue.offer(now + a);
      }

      if (now + b < visited.length && visited[now + b] == 0) {
        visited[now + b] = visited[now] + 1;
        queue.offer(now + b);
      }

      if (now - a >= 0 && visited[now - a] == 0) {
        visited[now - a] = visited[now] + 1;
        queue.offer(now - a);
      }

      if (now - b >= 0 && visited[now - b] == 0) {
        visited[now - b] = visited[now] + 1;
        queue.offer(now - b);
      }

      if (now * a < visited.length && visited[now * a] == 0) {
        visited[now * a] = visited[now] + 1;
        queue.offer(now * a);
      }

      if (now * b < visited.length && visited[now * b] == 0) {
        visited[now * b] = visited[now] + 1;
        queue.offer(now * b);
      }
    }
    return -1;
  }
}
