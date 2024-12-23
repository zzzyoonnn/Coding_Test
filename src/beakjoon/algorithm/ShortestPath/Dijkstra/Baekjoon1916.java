package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1916 {
  static int N, M;
  static int INF = Integer.MAX_VALUE / 2;
  static int[] costs;
  static ArrayList<ArrayList<Route>> routes;

  private static class Route implements Comparable<Route> {
    int destination;
    int cost;

    public Route(int destination, int cost) {
      this.destination = destination;
      this.cost = cost;
    }

    @Override
    public int compareTo(Route r) {
      return this.cost - r.cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());  // 도시의 개수
    M = Integer.parseInt(br.readLine());  // 버스의 개수

    initialize();

    StringTokenizer st;
    for (int line = 1; line <= M; line++) {
      st = new StringTokenizer(br.readLine());

      int origin = Integer.parseInt(st.nextToken());
      int destination = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      routes.get(origin).add(new Route(destination, cost));
    }

    st = new StringTokenizer(br.readLine());
    int inputOrigin = Integer.parseInt(st.nextToken());
    int inputDestination = Integer.parseInt(st.nextToken());

    dijkstra(inputOrigin, inputDestination);

    System.out.print(costs[inputDestination]);
  }

  private static void dijkstra(int inputOrigin, int inputDestination) {
    PriorityQueue<Route> pq = new PriorityQueue<>();
    pq.offer(new Route(inputOrigin, 0));
    boolean[] visited = new boolean[N + 1];
    costs[inputOrigin] = 0;

    while (!pq.isEmpty()) {
      Route r = pq.poll();
      int now = r.destination;
      visited[now] = true;

      if (now == inputDestination) break;

      for (Route next : routes.get(now)) {
        if (!visited[next.destination] && costs[next.destination] > next.cost + costs[now]) {
          costs[next.destination] = costs[now] + next.cost;
          pq.offer(new Route(next.destination, costs[next.destination]));
        }
      }
    }
  }

  private static void initialize() {
    routes = new ArrayList<>();
    for (int index = 0; index <= N; index++) {
      routes.add(new ArrayList<>());
    }

    costs = new int[N + 1];
    Arrays.fill(costs, INF);
  }
}
