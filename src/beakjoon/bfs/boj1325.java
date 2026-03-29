package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1325 {
  static int n, m;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new ArrayList[n + 1];
    for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

    for (int i = 1; i <= m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[b].add(a);
    }

    int[] count = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      visited = new boolean[n + 1];

      Queue<Integer> queue = new LinkedList<>();
      queue.add(i);
      visited[i] = true;

      while (!queue.isEmpty()) {
        int cur = queue.poll();
        for (int next : graph[cur]) {
          if (!visited[next]) {
            visited[next] = true;
            queue.add(next);
            count[i]++;
          }
        }
      }
    }

    int max = -1;
    for (int i = 0; i < count.length; i++) max = Math.max(max, count[i]);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < count.length; i++) {
      if (count[i] == max) sb.append(i).append(' ');
    }
    System.out.print(sb);
  }
}
