package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1697 {
  static int n, k;
  static int[] visited = new int[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    System.out.println(bfs(n));
  }

  private static int bfs(int x) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(x);

    int index = x;
    visited[index] = 1;

    while (!queue.isEmpty()) {
      int now = queue.remove();

      if (now == k) {
        return visited[n] - 1;
      }

      if (now - 1 >= 0 && visited[now - 1] == 0) {
        visited[now - 1] = visited[now] + 1;
        queue.add(now - 1);
      }

      if (now + 1 <= 10000 && visited[now + 1] == 0) {
        visited[now + 1] = visited[now] + 1;
        queue.add(now + 1);
      }

      if (2 * now <= 10000 && visited[2 * now] == 0) {
        visited[2 * now] = visited[now] + 1;
        queue.add(2 * now);
      }
    }

    return -1;
  }
}
