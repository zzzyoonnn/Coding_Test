package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1260 {
  static int n, m, order;
  static boolean[] visited;
  static ArrayList<Integer> graph[];
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    visited = new boolean[n + 1];
    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    for (int i = 1; i <= n; i++) Collections.sort(graph[i]);

    order = 1;
    dfs(v);
    sb.append("\n");

    order = 1;
    visited = new boolean[n + 1];
    bfs(v);
    System.out.print(sb.toString());
  }

  private static void bfs(int index) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(index);
    visited[index] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      sb.append(cur).append(" ");

      for (int next : graph[cur]) {

        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
        }

      }
    }
  }

  private static void dfs(int index) {
    visited[index] = true;
    sb.append(index).append(" ");

    for (int i : graph[index]) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }
}
