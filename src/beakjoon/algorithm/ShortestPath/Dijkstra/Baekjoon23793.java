package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon23793 {
  static int N, M;
  static int u, v, w;
  static int X, Y, Z;
  static ArrayList<ArrayList<Node>> graph;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static PriorityQueue<Node> pq;
  static int[] weight;

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
    initialize();

    int distanceXY = fromXtoY();
    int distanceYZ = fromYtoZ();

    int firstResult = distanceXY + distanceYZ;
    int secondResult = fromXtoZ();

    if (distanceXY == -1 || distanceYZ == -1) firstResult = -1;

    System.out.print(firstResult + " " + secondResult);
  }

  private static int dijkstra(int start, int end) {
    pq.clear();
    Arrays.fill(weight, Integer.MAX_VALUE / 2);
    weight[start] = 0;

    if (start == X && end == Z) {
      weight[Y] = -1;
    }

    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      int now = cur.destination;

      if (weight[now] < cur.weight) continue;

      if (now == end) {
        return cur.weight;
      }

      for (Node next : graph.get(now)) {
        if (start == X && end == Z && next.destination == Y) continue;

        if (weight[next.destination] > next.weight + weight[now]) {
          weight[next.destination] = next.weight + weight[now];

          pq.offer(new Node(next.destination, weight[next.destination]));
        }
      }
    }

    return -1;
  }

  private static int fromXtoZ() {
    return dijkstra(X, Z);
  }

  private static int fromYtoZ() {
    return dijkstra(Y, Z);
  }

  private static int fromXtoY() {
    return dijkstra(X, Y);
  }

  private static void setGoal() throws IOException {
    st = new StringTokenizer(br.readLine());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());
    Z = Integer.parseInt(st.nextToken());
  }

  private static void makeGraph() throws IOException {
    for (int line = 1; line <= M; line++) {
      st = new StringTokenizer(br.readLine());

      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new Node(v, w));
    }
  }

  private static void initialize() throws IOException{
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());   // 정점의 수
    M = Integer.parseInt(st.nextToken());   // 간선의 수

    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    makeGraph();

    pq = new PriorityQueue<>();
    weight = new int[N + 1];

    setGoal();
  }
}
