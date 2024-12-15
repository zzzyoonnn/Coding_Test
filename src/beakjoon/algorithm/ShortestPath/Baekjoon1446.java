package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1446 {
  static int N, D;
  static ArrayList<ArrayList<Road>> roads;
  static int[] dist;
  static boolean[] checked;
  static int INF = Integer.MAX_VALUE / 2;

  private static class Road implements Comparable<Road> {
    int destination;
    int distance;

    public Road(int destination, int distance) {
      this.destination = destination;
      this.distance = distance;
    }

    @Override
    public int compareTo(Road r) {    // 오름차순 정렬
      return this.distance - r.distance;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());   // 지름길
    D = Integer.parseInt(st.nextToken());   // 고속도로의 길이

    roads = new ArrayList<>();
    for (int index = 0; index < 10001; index++) {
      roads.add(new ArrayList<>());
    }

    dist = new int[D + 1];
    Arrays.fill(dist, INF);

    for (int info = 1; info <= N; info++) {
      st = new StringTokenizer(br.readLine());
      int origin = Integer.parseInt(st.nextToken());
      int destination = Integer.parseInt(st.nextToken());
      int distance = Integer.parseInt(st.nextToken());

      if (destination > D) continue;
      if (destination - origin > distance) {
        roads.get(origin).add(new Road(destination, distance));
      }
    }

    dijkstra(0);
    System.out.print(dist[D]);
  }

  private static void dijkstra(int pos) {
    PriorityQueue<Road> pq = new PriorityQueue<>();
    pq.offer(new Road(pos, 0));
    checked = new boolean[D + 1];
    dist[pos] = 0;

    while(!pq.isEmpty()) {
      Road now = pq.poll();
      pos = now.destination;
      checked[pos] = true;

      if (pos == D) break;

      // 지름길을 이용하지 않는 경우
      if (dist[pos + 1] > now.distance + 1) {
        dist[pos + 1] = now.distance + 1;
        pq.offer(new Road(pos + 1, dist[pos + 1]));
      }

      // 지름길을 이용하는 경우
      for (Road next : roads.get(pos)) {
        if (!checked[next.destination] && dist[next.destination] > dist[pos] + next.distance) {
          dist[next.destination] = dist[pos] + next.distance;
          pq.offer(new Road(next.destination, dist[next.destination]));
        }
      }
    }
  }
}
