package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2644 {
  static int n, start, end;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      graph[x].add(y);
      graph[y].add(x);
    }

    int result = dfs(start, 0);

    System.out.print(result);
  }

  private static int dfs(int index, int depth) {
    visited[index] = true;

    if (index == end) return depth;

    for (int i : graph[index]) {
      if (!visited[i]) {
        int result = dfs(i, depth + 1);
        if (result != -1) return result;
      }
    }

    return -1;
  }
}
