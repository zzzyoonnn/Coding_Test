package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1753 {
  static int V, E, K;
  static int INF = Integer.MAX_VALUE / 2;
  static ArrayList<ArrayList<Node>> graph;
  static int[] minWeight;

  private static class Node implements Comparable<Node> {
    int destination;
    int weight;

    public Node(int destination, int weight) {
      this.destination = destination;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return this.weight - o.weight;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());   // 정점의 개수
    E = Integer.parseInt(st.nextToken());   // 간선의 개수
    K = Integer.parseInt(br.readLine());    // 시작 정점의 번호

    initialize();

    for (int input = 1; input <= E; input++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new Node(v, w));
    }

    dijkstra();

    System.out.print(result());
  }

  private static String result() {
    StringBuilder sb = new StringBuilder();

    for (int index = 1; index <= V; index++) {
      int num = minWeight[index];
      if (num == INF) {
        sb.append("INF").append('\n');
      } else {
        sb.append(num).append('\n');
      }
    }

    return sb.toString();
  }

  private static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[V + 1];
    pq.offer(new Node(K, 0));
    minWeight[K] = 0;

    while (!pq.isEmpty()) {
      Node n = pq.poll();
      int now = n.destination;
      visited[now] = true;


      for (Node next : graph.get(now)) {
        if (!visited[next.destination] && minWeight[next.destination] > next.weight + minWeight[now]) {
          minWeight[next.destination] = next.weight + minWeight[now];

          pq.offer(new Node(next.destination, minWeight[next.destination]));
        }
      }
    }
  }

  private static void initialize() {
    graph = new ArrayList<>();
    for (int index = 0; index <= V; index++) {
      graph.add(new ArrayList<>());
    }

    minWeight = new int[V + 1];
    Arrays.fill(minWeight, INF);
  }
}
