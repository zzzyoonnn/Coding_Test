package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj18352 {
  static int n, m, k, x;
  static ArrayList<Integer>[] city;
  static int[] result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    city = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) city[i] = new ArrayList<>();

    result = new int[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      city[a].add(b);
    }

    bfs(x);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      if (result[i] == k) sb.append(i).append('\n');
    }

    if (sb.length() == 0) sb.append(-1);
    System.out.print(sb);
  }

  private static void bfs(int start) {
    Arrays.fill(result, -1);
    result[start] = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int next : city[now]) {
        if (result[next] == -1) {
          result[next] = result[now] + 1;
          queue.add(next);
        }
      }
    }
  }
}
