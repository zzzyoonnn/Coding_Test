package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon24484 {
  static int n, m, count = 1;
  static long[] order, depth;
  static ArrayList<Integer>[] list;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());       // the number of vertices
    m = Integer.parseInt(st.nextToken());       // the number of trunk lines
    int r = Integer.parseInt(st.nextToken());   // starting point

    list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

    visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      list[u].add(v);
      list[v].add(u);
    }

    for (int i = 1; i <= n; i++) Collections.sort(list[i], Collections.reverseOrder());

    order = new long[n + 1];
    depth = new long[n + 1];
    for (int i = 1; i <= n; i++) order[i] = 0;
    for (int i = 1; i <= n; i++) depth[i] = -1;
    order[r] = 1;
    depth[r] = 0;
    dfs(r, 0);

    //System.out.println(Arrays.toString(depth));
    //System.out.println(Arrays.toString(order));

    long answer = 0;
    for (int i = 0; i < depth.length; i++) {
      answer += depth[i] * order[i];
    }

    System.out.print(answer);
  }

  private static void dfs(int index, long dep) {
    visited[index] = true;
    order[index] = dep;
    depth[index] = count++;

    //System.out.println(index + " " + depth);

    for (int i : list[index]) {
      if (!visited[i]) {
        dfs(i, dep + 1);
      }
    }
  }
}
