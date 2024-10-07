package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon18126 {
  static int n;
  static long answer = -1;
  static ArrayList<Node>[] list;
  static boolean[] visited;

  static class Node{
    int idx;
    long value;

    public Node(int idx, long value) {
      this.idx = idx;
      this.value = value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());    // the number of rooms

    // Reset room information
    list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

    visited = new boolean[n + 1];

    StringTokenizer st;
    for (int i = 1; i <= n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      long distance = Integer.parseInt(st.nextToken());
      list[u].add(new Node(v, distance));
      list[v].add(new Node(u, distance));
    }

    dfs(1, 0);

    System.out.print(answer);

  }

  private static void dfs(int index, long distance) {
    visited[index] = true;

    answer = Math.max(answer, distance);

    for (Node nd : list[index]) {
      if (!visited[nd.idx]) {
        dfs(nd.idx, distance + nd.value);
      }
    }
  }
}
