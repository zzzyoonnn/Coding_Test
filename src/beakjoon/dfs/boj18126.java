package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj18126 {
  static int n;
  static ArrayList<Node>[] graph;
  static boolean[] visited;
  static long[] distance;

  static class Node {
    int index, dist;

    Node(int index, int dist) {
      this.index = index;
      this.dist = dist;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    graph = new ArrayList[n + 1];
    distance = new long[n + 1];
    visited = new boolean[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph[a].add(new Node(b, c));
      graph[b].add(new Node(a, c));
    }

    dfs(1);

    long max = -1;
    for (long l : distance) {
      max = Math.max(max, l);
    }
    System.out.print(max);
  }

  private static void dfs(int index) {
    visited[index] = true;

    for (Node next : graph[index]) {
      if (!visited[next.index]) {
        distance[next.index] = distance[index] + next.dist;
        dfs(next.index);
      }
    }
  }
}
