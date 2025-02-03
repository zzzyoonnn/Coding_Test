package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon10282 {
  static StringTokenizer st;
  static ArrayList<ArrayList<Computer>> computers;

  private static class Computer implements Comparable<Computer> {
    int connection;
    int time;

    public Computer(int connection, int time) {
      this.connection = connection;
      this.time = time;
    }

    @Override
    public int compareTo(Computer o) {
      return this.time - o.time;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    int n, d, c;

    for (int tc = 0; tc < t; tc++) {
      int[] data = inputData(br.readLine());

      n = data[0];
      d = data[1];
      c = data[2];

      connectComputer(d, br.readLine());

      int[] result = dijkstra(n, c);
      System.out.println(result[0] + " " + result[1]);
    }
  }

  private static int[] dijkstra(int n, int c) {
    int[] time = new int[n + 1];
    Arrays.fill(time, Integer.MAX_VALUE / 2);

    PriorityQueue<Computer> pq = new PriorityQueue<>();
    pq.add(new Computer(c, 0));
    boolean[] visited = new boolean[n + 1];

    time[c] = 0;

    int count = 0;
    int resultTime = 0;
    while (!pq.isEmpty()) {
      Computer cur = pq.poll();
      int now = cur.connection;

      if (visited[now]) continue;
      visited[now] = true;
      count++;
      resultTime = time[now];

      for (Computer computer : computers.get(now)) {
        if (time[computer.connection] > computer.time + time[now]) {
          time[computer.connection] = computer.time + time[now];
          pq.add(new Computer(computer.connection, time[computer.connection]));
        }
      }
    }

    return new int[]{count, resultTime};
  }

  private static void connectComputer(int d, String str) {
    for (int i = 0; i < d; i++) {
      st = new StringTokenizer(str);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());

      computers.get(b).add(new Computer(a, s));
    }
  }

  private static int[] inputData(String s) {
    st = new StringTokenizer(s);
    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    computers = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      computers.add(new ArrayList<>());
    }

    return new int[]{n, d, c};
  }
}
