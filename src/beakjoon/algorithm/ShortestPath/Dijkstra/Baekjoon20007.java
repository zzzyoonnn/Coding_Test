package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon20007 {

  private static class Node implements Comparable<Node> {
    int destination;
    long length;

    public Node(int destination, long length) {
      this.destination = destination;
      this.length = length;
    }

    @Override
    public int compareTo(Node o) {
      return Long.compare(this.destination, o.destination);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());

    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    for (int index = 0; index <= N - 1; index++) {
      graph.add(new ArrayList<>());
    }

    for (int input = 0; input < M; input++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }

    boolean[] visited = new boolean[N];
    int[] day = new int[N];
    long[] distance = new long[N];

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(Y, 0));
    int INF = Integer.MAX_VALUE;
    Arrays.fill(distance, INF);
    Arrays.fill(day, -1);
    day[Y] = 1;
    distance[Y] = 0;

    int answer = 1;
    int standard = X;
    while (!pq.isEmpty()) {
      Node now = pq.poll();

      //System.out.println(now.destination + ", distance : " + Arrays.toString(distance));
      // System.out.println("day : " + Arrays.toString(day));

      if (visited[now.destination]) continue;
      visited[now.destination] = true;

      for (Node neighbor : graph.get(now.destination)) {
        if (distance[neighbor.destination] > distance[now.destination] + neighbor.length) {
          if (distance[now.destination] + (neighbor.length * 2) <= standard) {
            distance[neighbor.destination] = distance[now.destination] + (neighbor.length * 2);
            day[neighbor.destination] = day[now.destination];
            standard -= neighbor.length * 2;
            pq.offer(new Node(neighbor.destination, distance[neighbor.destination]));
          } else {
            //System.out.println("초과");
            answer++;
            day[neighbor.destination] = answer;
            standard = X;
            pq.offer(new Node(neighbor.destination, 0));

          }
        }
      }

      //System.out.println(Arrays.toString(day));

    }
    for (int index : day) {
      if (index == -1) {
        answer = -1;
        break;
      }
    }

    System.out.println(answer);
  }
}