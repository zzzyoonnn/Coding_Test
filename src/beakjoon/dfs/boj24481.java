package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj24481 {
  static int n, m, r, depth;
  static ArrayList<Integer>[] graph;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    graph = new ArrayList[n + 1];
    dist = new int[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    depth = 0;
    Arrays.fill(dist, -1);
    for (int i = 1; i <= n; i++) Collections.sort(graph[i]);
    dist[r] = 0;
    dfs(r);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(dist[i]).append('\n');
    }
    System.out.print(sb);
  }

  private static void dfs(int index) {

    for (int next : graph[index]) {
      if (dist[next] == -1) {
        dist[next] = dist[index] + 1;
        dfs(next);
      }
    }
  }
}
