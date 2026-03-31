package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15900 {
  static int n, result;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    dfs(1, 0);

    System.out.print(result % 2 == 0 ? "No" : "Yes");
  }

  private static void dfs(int node, int depth) {
    visited[node] = true;

    boolean isLeaf = true;

    for (int next : graph[node]) {
      if (!visited[next]) {
        isLeaf = false;
        dfs(next, depth + 1);
      }
    }

    if (isLeaf) result += depth;
  }
}
