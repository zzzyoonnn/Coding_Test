package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj24444 {
  static int n, m, r, depth;
  static ArrayList<Integer>[] graph;
  static int[] result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    graph = new ArrayList[n + 1];
    result = new int[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    for (int i = 1; i <= n; i++) Collections.sort(graph[i]);

    bfs(r);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(result[i]).append('\n');
    }
    System.out.print(sb);
  }

  private static void bfs(int index) {
    depth = 1;
    result[index] = depth;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(index);

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for (int next : graph[cur]) {
        if (result[next] == 0) {
          depth++;
          result[next] = depth;
          queue.add(next);
        }
      }
    }
  }
}
