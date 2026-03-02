package beakjoon.archive.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon11725_1 {
  static int n;
  static ArrayList<Integer>[] list;
  static int[] parent;
  static boolean[] visited;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    list = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
      list[i] = new ArrayList<>();
    }

    parent = new int[n + 1];
    visited = new boolean[n + 1];

    StringTokenizer st;
    for (int i = 1; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list[a].add(b);
      list[b].add(a);
    }

    dfs(1);

    for (int i = 2; i <= n; i++) {
      System.out.println(parent[i]);
    }
  }

  private static void dfs(int node) {
    visited[node] = true;

    for (int i : list[node]) {
      if (!visited[i]) {
        parent[i] = node;
        dfs(i);
      }
    }
  }
}
