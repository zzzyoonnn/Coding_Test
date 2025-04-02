package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1939 {
  static int N, M, f1, f2;
  static ArrayList<HashMap<Integer, Integer>> graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new HashMap<>());
    }

    int minWeight = Integer.MAX_VALUE;
    int maxWeight = 0;

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph.get(a).put(b, Math.max(graph.get(a).getOrDefault(b, 0), c));
      graph.get(b).put(a, Math.max(graph.get(b).getOrDefault(a, 0), c));

      minWeight = Math.min(minWeight, c);
      maxWeight = Math.max(maxWeight, c);
    }

    st = new StringTokenizer(br.readLine());
    f1 = Integer.parseInt(st.nextToken());
    f2 = Integer.parseInt(st.nextToken());

    System.out.println(binarySearch(minWeight, maxWeight));
  }

  private static int binarySearch(int left, int right) {
    int answer = left;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (bfs(mid)) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return answer;
  }

  private static boolean bfs(int weightLimit) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[N + 1];

    q.offer(f1);
    visited[f1] = true;

    while (!q.isEmpty()) {
      int now = q.poll();

      if (now == f2) {
        return true;
      }

      for (int next : graph.get(now).keySet()) {
        int bridgeWeight = graph.get(now).get(next);

        if (!visited[next] && bridgeWeight >= weightLimit) {
          visited[next] = true;
          q.offer(next);
        }
      }
    }

    return false;
  }
}