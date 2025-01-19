package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1504 {
  static int N, E;
  static int[] dist;
  static boolean[] visited;
  static final int INF = 200000000;
  static ArrayList<ArrayList<Node>> graph;

  private static class Node implements Comparable<Node> {
    int destination;
    int distance;

    public Node(int destination, int distance) {
      this.destination = destination;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
      return this.distance - o.distance;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());   // 정점의 개수
    E = Integer.parseInt(st.nextToken());   // 간선의 개수

    graph = new ArrayList<>();
    dist = new int[N + 1];
    Arrays.fill(dist, INF);

    visited = new boolean[N + 1];

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int distance = Integer.parseInt(st.nextToken());

      graph.get(start).add(new Node(end, distance));
      graph.get(end).add(new Node(start, distance));
    }

    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    int res1 = 0;
    res1 += dijkstra(1, v1);
    res1 += dijkstra(v1, v2);
    res1 += dijkstra(v2, N);

    int res2 = 0;
    res2 += dijkstra(1, v2);
    res2 += dijkstra(v2, v1);
    res2 += dijkstra(v1, N);

    if (res1 >= INF && res2 >= INF) System.out.print(-1);
    else System.out.print(Math.min(res1, res2));
  }

  private static int dijkstra(int start, int end) {
    Arrays.fill(dist, INF);
    Arrays.fill(visited, false);

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));
    dist[start] = 0;
    //visited[start] = true;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      int now = cur.destination;

      visited[now] = true;

        for (Node node : graph.get(now)) {
          if (!visited[node.destination] && dist[node.destination] > dist[now] + node.distance) {
            dist[node.destination] = dist[now] + node.distance;
            pq.add(new Node(node.destination, dist[node.destination]));
          }
      }
    }

    return dist[end];
  }
}
