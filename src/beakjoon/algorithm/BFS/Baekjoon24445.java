package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon24445 {
  static int n, m, r;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    visited = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list.get(a).add(b);
      list.get(b).add(a);
    }

    for (List<Integer> l : list) {
      Collections.sort(l, Collections.reverseOrder());
    }

    bfs(r);
  }

  private static void bfs(int r) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(r);
    visited[r] = true;
    int cnt = 0;
    int[] count = new int[n + 1];

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      count[cur] = ++cnt;

      for (int i = 0; i < list.get(cur).size(); i++) {
        int next = list.get(cur).get(i);

        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      System.out.println(count[i]);
    }
  }
}
