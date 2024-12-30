package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon5972 {
  static int N, M;
  static ArrayList<ArrayList<Barn>> barn;
  static final int INF = Integer.MAX_VALUE / 2;
  static long[] cost;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  private static class Barn implements Comparable<Barn> {
    int destination;
    long cows;

    public Barn(int destination, long cows) {
      this.destination = destination;
      this.cows = cows;
    }

    @Override
    public int compareTo(Barn o) {
      return Long.compare(this.cows, o.cows);
    }
  }

  public static void main(String[] args) throws IOException {
    inputSetting();

    initialize();

    inputBarnData();

    dijkstra();
  }

  private static void dijkstra() {
    PriorityQueue<Barn> pq = new PriorityQueue<>();
    pq.add(new Barn(1, 0));
    boolean[] visited = new boolean[N + 1];

    cost[1] = 0;

    while (!pq.isEmpty()) {
      Barn curr = pq.poll();
      int now = curr.destination;
      visited[now] = true;

      for (Barn b : barn.get(now)) {
        if (!visited[b.destination] && cost[b.destination] > b.cows + cost[now]) {
          cost[b.destination] = b.cows + cost[now];
          pq.add(new Barn(b.destination, cost[b.destination]));
        }
      }
    }

    System.out.print(cost[N]);
  }

  private static void inputBarnData() throws IOException {
    for (int line = 1; line <= M; line++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      barn.get(a).add(new Barn(b, c));
      barn.get(b).add(new Barn(a, c));
    }
  }

  private static void initialize() {
    barn = new ArrayList<>();

    for (int i = 0; i <= N; i++) {
      barn.add(new ArrayList<>());
    }

    cost = new long[N + 1];
    Arrays.fill(cost, INF);
  }

  private static void inputSetting() throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());   // 헛간의 개수
    M = Integer.parseInt(st.nextToken());   // 거리의 개수
  }
}
