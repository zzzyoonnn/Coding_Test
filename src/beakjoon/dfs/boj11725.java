package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11725 {
  static int n;
  static boolean[] visited;
  static ArrayList<Integer> node[];
  static int[] result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    visited = new boolean[n + 1];
    node = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) node[i] = new ArrayList<>();
    result = new int[n + 1];

    StringTokenizer st;
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      node[u].add(v);
      node[v].add(u);
    }

    dfs(1);

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= n; i++) {
      sb.append(result[i]).append("\n");
    }
    System.out.print(sb);
  }

  private static void dfs(int index) {
    visited[index] = true;

    for (int i : node[index]) {
      if (!visited[i]) {
        result[i] = index;
        dfs(i);
      }
    }
  }
}
