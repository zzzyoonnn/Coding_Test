package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj5567 {
  static int n, m;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    graph = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    dist = new int[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    bfs(1);

    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (dist[i] == 1 || dist[i] == 2) result++;
    }

    System.out.print(result);
  }

  private static void bfs(int index) {
    visited[index] = true;
    Arrays.fill(dist, -1);
    dist[index] = 0;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(index);

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for (int next : graph[cur]) {
        if (!visited[next]) {
          dist[next] = dist[cur] + 1;
          visited[next] = true;
          queue.add(next);
        }
      }
    }
  }
}
