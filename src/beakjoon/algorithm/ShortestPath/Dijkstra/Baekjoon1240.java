package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1240 {
  static int N, M;
  static ArrayList<ArrayList<Node>> list;
  static int[] cost;
  static boolean[] checked;
  static final int INF = 10_000 * 1_000;

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

    list = new ArrayList<>();
    for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

    cost = new int[N + 1];

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      list.get(a).add(new Node(b, c));
      list.get(b).add(new Node(a, c));
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int to = Integer.parseInt(st.nextToken());
      int from = Integer.parseInt(st.nextToken());

      Arrays.fill(cost, INF);
      dijkstra(to, from);
      System.out.println(cost[from]);
    }

  }

  private static void dijkstra(int start, int end) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));
    checked = new boolean[N + 1];
    cost[start] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      start = cur.to;
      checked[start] = true;

      if (start == end) break;

      for (Node next : list.get(start)) {
        if (!checked[next.to] && cost[next.to] > cost[start] + next.cost) {
          cost[next.to] = cost[start] + next.cost;
          pq.offer(new Node(next.to, cost[next.to]));
        }
      }
    }
  }
}
