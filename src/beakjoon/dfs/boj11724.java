package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11724 {
  static int n, m;
  static boolean[] visited;
  static ArrayList<Integer> list[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    visited = new boolean[n + 1];
    list = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list[a].add(b);
      list[b].add(a);
    }

    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        dfs(i);
        count++;
      }
    }

    System.out.print(count);
  }

  private static void dfs(int index) {
    visited[index] = true;

    for (int i : list[index]) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }
}
