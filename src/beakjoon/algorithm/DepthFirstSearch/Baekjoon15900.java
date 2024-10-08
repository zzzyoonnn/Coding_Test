package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon15900 {
  static int n, answer = 0;
  static ArrayList<Integer>[] list;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

    StringTokenizer st;
    for (int i = 1; i <= n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      list[u].add(v);
      list[v].add(u);
    }
    br.close();

    visited = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        dfs(i, 0);
      }
    }

    if (answer % 2 == 1) System.out.print("Yes");
    else System.out.print("No");
  }

  private static void dfs(int index, int count) {
    visited[index] = true;

    for (int i : list[index]) {
      if (!visited[i]) {
        dfs(i, count + 1);
      }
    }

    if (index != 1 && list[index].size() == 1) {
      answer += count;
    }
  }
}
