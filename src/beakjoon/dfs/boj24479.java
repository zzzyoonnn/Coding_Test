package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj24479 {
  static int n, m, order;
  static int[] visited;
  static ArrayList<Integer> graph[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    visited = new int[n + 1];
    graph = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    for (int i = 1; i <= n; i++) Collections.sort(graph[i]);

    order = 1;
    dfs(r);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(visited[i]).append("\n");
    }

    System.out.println(sb.toString());
  }

  private static void dfs(int index) {
    visited[index] = order++;

    for (int i : graph[index]) {
      if (visited[i] == 0) {
        dfs(i);
      }
    }
  }
}
