package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2606 {
  static int n, m, count;
  static boolean[] visited;
  static ArrayList<Integer> graph[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    visited = new boolean[n + 1];
    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    count = 0;
    dfs(1);

    System.out.println(count);
  }

  private static void dfs(int index) {
    visited[index] = true;

    for (int i : graph[index]) {
      if (!visited[i]) {
        count++;
        dfs(i);
      }
    }
  }
}
