package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon18352 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    List<Integer>[] edges = new List[n + 1];
    for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      edges[a].add(b);
    }

    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    Queue<Integer> queue = new LinkedList<>();
    queue.add(x);
    dist[x] = 0;

    List<Integer> answer = new ArrayList<>();

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      if (dist[cur] > k) break;
      if (dist[cur] == k) answer.add(cur);

      for (int index : edges[cur]) {
        if (dist[index] != Integer.MAX_VALUE) continue;
        dist[index] = dist[cur] + 1;
        queue.add(index);
      }
    }

    Collections.sort(answer);
    StringBuilder sb = new StringBuilder();
    for (int i : answer) {
      sb.append(i).append("\n");
    }

    System.out.print(answer.isEmpty() ? -1 : sb.toString());
  }
}
