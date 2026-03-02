package beakjoon.archive.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1916_1 {
  static int n, m;
  static ArrayList<ArrayList<Bus>> list;
  static boolean[] checked;
  static int[] result;
  static int INF = Integer.MAX_VALUE;

  private static class Bus implements Comparable<Bus> {
    int destination;
    int cost;

    public Bus(int destination, int cost) {
      this.destination = destination;
      this.cost = cost;
    }

    @Override
    public int compareTo(Bus b) {
      return this.cost - b.cost;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    list = new ArrayList<>();
    for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
    checked = new boolean[n + 1];

    result = new int[n + 1];
    Arrays.fill(result, INF);

    StringTokenizer st;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      list.get(start).add(new Bus(end, cost));
    }

    st = new StringTokenizer(br.readLine());
    int startTarget = Integer.parseInt(st.nextToken());
    int endTarget = Integer.parseInt(st.nextToken());

    dijkstra(startTarget);

    System.out.print(result[endTarget]);
  }

  private static void dijkstra(int start) {
    PriorityQueue<Bus> q = new PriorityQueue<>();
    q.offer(new Bus(start, 0));
    result[start] = 0;

    while (!q.isEmpty()) {
      Bus bus = q.poll();
      int now = bus.destination;
      int nowCost = bus.cost;

      if (nowCost > result[now]) continue;

      for (Bus b : list.get(now)) {
        int nextCost = b.cost + nowCost;
        if (nextCost < result[b.destination]) {
          result[b.destination] = nextCost;
          q.offer(new Bus(b.destination, nextCost));
        }
      }
    }
  }
}
