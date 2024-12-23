package beakjoon.algorithm.Dijkstra;

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

  private static void dijkstra(int now) {
    PriorityQueue<Road> pq = new PriorityQueue<>();
    pq.offer(new Road(now, 0));
    checked = new boolean[D + 1];
    dist[now] = 0;

    while(!pq.isEmpty()) {
      Road pos = pq.poll();
      now = pos.destination;
      checked[now] = true;

      if (now == D) break;

      // 1씩 이동하는 경우
      if (dist[now + 1] > pos.distance + 1) {
        dist[now + 1] = pos.distance + 1;
        pq.offer(new Road(now + 1, dist[now + 1]));
      }

      // 지름길을 이용하는 경우
      for (Road next : roads.get(now)) {
        // 방문하지 않은 노드이며, 기존의 최단거리보다 더 짧다면
        if (!checked[next.destination] && dist[next.destination] > dist[now] + next.distance) {
          dist[next.destination] = dist[now] + next.distance;   // 더 짧은 거리로 갱신
          pq.offer(new Road(next.destination, dist[next.destination]));
        }
      }
    }
  }
}
