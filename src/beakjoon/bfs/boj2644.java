package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2644 {
  static int n, start, end;
  static boolean[] visited;
  static ArrayList<Integer>[] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());

    int x, y;
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      graph[x].add(y);
      graph[y].add(x);
    }

    int result = bfs(start);
    System.out.print(result);
  }

  private static int bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    int[] dist = new int[n + 1];
    visited[start] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      if (cur == end) return dist[cur];

      for (int next : graph[cur]) {
        if (!visited[next]) {
          visited[next] = true;
          dist[next] = dist[cur] + 1;
          queue.add(next);
        }
      }
    }

    return -1;
  }
}
