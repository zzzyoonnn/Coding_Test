package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon20007 {
  static int N, M, X, Y;
  static boolean[] visited;
  static int[] day;
  static int[] distance;
  static ArrayList<ArrayList<Node>> graph;

  private static class Node implements Comparable<Node> {
    int destination;
    int length;

    public Node(int destination, int length) {
      this.destination = destination;
      this.length = length;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.length, o.length);
    }
  }

  public static void main(String[] args) throws IOException {
    initialize();

    dijkstra();

    deliver();
  }

  private static void deliver() {
    int total = 0;
    int day = 1;
    for (int index : distance) {
      if ((index * 2) > X) {
        day = -1;
        break;
      }

      total += (index * 2);

      if (total > X) {
        day++;
        total = (index * 2);
      }
    }

    System.out.print(day);
  }

  private static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(Y, 0));
    int INF = Integer.MAX_VALUE;
    Arrays.fill(distance, INF);
    Arrays.fill(day, -1);
    day[Y] = 1;
    distance[Y] = 0;

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (visited[now.destination]) continue;
      visited[now.destination] = true;

      for (Node neighbor : graph.get(now.destination)) {
        if (distance[neighbor.destination] > distance[now.destination] + neighbor.length) {
          distance[neighbor.destination] = distance[now.destination] + neighbor.length;
          pq.offer(new Node(neighbor.destination, distance[neighbor.destination]));
        }
      }
    }

    Arrays.sort(distance);
  }

  private static void initialize() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    visited = new boolean[N];
    day = new int[N];
    distance = new int[N];

    graph = new ArrayList<>();
    for (int index = 0; index <= N - 1; index++) {
      graph.add(new ArrayList<>());
    }

    for (int input = 0; input < M; input++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      // 양방향 이동
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }
  }
}