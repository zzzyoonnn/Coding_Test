package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon1240 {
  static int N, M, answer;
  static ArrayList<Node>[] list;
  static boolean[] visited;

  private static class Node implements Comparable<Node> {
    int to;
    int cost;

    public Node(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());   // 노드의 개수
    M = Integer.parseInt(st.nextToken());   // 거리를 알고싶은 노드 쌍의 개수

    list = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

    visited = new boolean[N + 1];

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      list[a].add(new Node(b, c));
      list[b].add(new Node(a, c));
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int to = Integer.parseInt(st.nextToken());
      int from = Integer.parseInt(st.nextToken());
      dfs(to, -1, from, 0);
      System.out.println(answer);
    }

  }

  private static void dfs(int to, int pa, int from, int cost) {
    if (to == from) {
      answer = cost;
    }
    for (Node next : list[to]) {
      if (next.to != pa) {
        dfs(next.to, to, from, cost + next.cost);
      }
    }
  }
}
