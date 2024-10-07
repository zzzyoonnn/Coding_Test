package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon24483 {
  static int n, m;
  static long order = 0, answer = 0;
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

    for (int i = 1; i <= n; i++) {
      Collections.sort(list[i]);
    }

    dfs(r, 0);

    System.out.println(answer);
  }

  private static void dfs(int index, long depth) {
    visited[index] = true;
    //System.out.println(depth + " " + order);

    answer += (depth * ++order);

    //System.out.println(answer);

    for (int i : list[index]) {
      if (!visited[i]) {
        dfs(i, depth + 1);
      }
    }
  }
}
