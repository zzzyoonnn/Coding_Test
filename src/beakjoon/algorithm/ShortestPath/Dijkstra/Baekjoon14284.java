package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon14284 {
  private static class Node implements Comparable<Node> {
    int destination;
    long weight;

    public Node (int destination, long weight) {
      this.destination = destination;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return Long.compare(this.weight, o.weight);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());   // 정점의 개수
    int M = Integer.parseInt(st.nextToken());   // 간선의 수

    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int input = 1; input <= M; input++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }

    long[] cost = new long[N + 1];
    final long INF = Long.MAX_VALUE / 2;
    Arrays.fill(cost, INF);

    st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(s, 0));
    cost[s] = 0;
    boolean[] visited = new boolean[N + 1];

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      int now = cur.destination;
      visited[now] = true;

      for (Node next : graph.get(now)) {
        if (!visited[next.destination] && cost[next.destination] > cost[now] + next.weight) {
          cost[next.destination] = cost[now] + next.weight;
          pq.add(new Node(next.destination, cost[next.destination]));
        }
      }
    }
    System.out.print(cost[t]);
  }
}
