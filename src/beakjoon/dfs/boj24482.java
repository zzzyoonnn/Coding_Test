package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj24482 {
  static int n, m, count;
  static int[] depth;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    count = 0;

    depth = new int[n + 1];
    Arrays.fill(depth, -1);
    depth[r] = 0;

    visited = new boolean[n + 1];
    graph = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    for (int i = 0; i <= n; i++) Collections.sort(graph[i], Collections.reverseOrder());

    dfs(r);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(depth[i]).append("\n");
    }
    System.out.print(sb);
  }

  private static void dfs(int index) {
    visited[index] = true;

    for (int next : graph[index]) {
      if (!visited[next]) {
        depth[next] = depth[index] + 1;
        dfs(next);
      }
    }
  }
}
