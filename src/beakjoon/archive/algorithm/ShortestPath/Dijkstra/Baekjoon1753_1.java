package beakjoon.archive.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1753_1 {
  static int v, e, k;
  final static int INF = Integer.MAX_VALUE;
  static ArrayList<ArrayList<Node>> list;
  static boolean[] visited;
  static int[] result;

  private static class Node implements Comparable<Node> {
    int e;
    int w;

    public Node(int e, int w) {
      this.e = e;
      this.w = w;
    }

    @Override
    public int compareTo(Node o) {
      return this.w - o.w;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(br.readLine());

    list = new ArrayList<>();
    for (int i = 0; i <= v; i++) list.add(new ArrayList<>());
    visited = new boolean[v + 1];
    result = new int[v + 1];

    Arrays.fill(result, INF);

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      list.get(start).add(new Node(end, weight));
    }

    dijkstra(k);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= v; i++) {
      if (result[i] == INF) sb.append("INF");
      else sb.append(result[i]);

      sb.append("\n");
    }

    System.out.print(sb);

  }

  private static void dijkstra(int start) {
    PriorityQueue<Node> q = new PriorityQueue<>();
    q.offer(new Node(start, 0));
    visited[start] = true;
    result[start] = 0;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      int now = cur.e;
      visited[now] = true;

      for (Node n : list.get(now)) {
        if (!visited[n.e] && result[now] + n.w < result[n.e]) {
          result[n.e] = result[now] + n.w;

          q.offer(new Node(n.e, result[n.e]));
        }
      }
    }
  }
}
