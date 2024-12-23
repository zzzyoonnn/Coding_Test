package beakjoon.algorithm.ShortestPath.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon17396 {
  private static class Branch implements Comparable<Branch> {
    int connection;
    long time;

    public Branch(int connection, long time) {
      this.connection = connection;
      this.time = time;
    }

    @Override
    public int compareTo(Branch o) {
      if (this.time - o.time > 0) return 1;    // Ascending sort
      return -1;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());   // 분기점 수
    int M = Integer.parseInt(st.nextToken());   // 분기점을 잇는 길의 수

    // 각 분기점이 적의 시야에 보이는가?(0: 안보임, 1: 보임)
    int[] status = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int index = 0; index < status.length; index++) {
      status[index] = Integer.parseInt(st.nextToken());
    }

    ArrayList<ArrayList<Branch>> branch = new ArrayList<>();
    for (int index = 0; index < N; index++) {
      branch.add(new ArrayList<>());
    }

    long[] time = new long[N];
    Arrays.fill(time, Long.MAX_VALUE);

    for (int info = 0; info < M; info++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());

      branch.get(a).add(new Branch(b, t));
      branch.get(b).add(new Branch(a, t));
    }

    PriorityQueue<Branch> pq = new PriorityQueue<>();
    pq.offer(new Branch(0, 0));
    boolean[] visited = new boolean[N];
    time[0] = 0;

    long answer = -1;
    while (!pq.isEmpty()) {
      Branch b = pq.poll();
      int now = b.connection;
      if (status[now] != 0 && now != N - 1) continue;
      if (b.time > time[now]) continue;
      visited[now] = true;

      if (now == N - 1) {
        answer = time[now];
        break;
      }

      for (Branch child : branch.get(now)) {
        if ((status[child.connection] == 0 || child.connection == N - 1) && !visited[child.connection] && time[child.connection] > child.time + time[now]) {
          time[child.connection] = child.time + time[now];
          pq.offer(new Branch(child.connection, time[child.connection]));
        }
      }
    }

    System.out.print(answer);
  }
}
