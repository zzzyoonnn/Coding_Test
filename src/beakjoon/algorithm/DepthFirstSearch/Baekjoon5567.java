package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon5567 {
  static int n, m, count;
  static ArrayList<Integer>[] list;
  static boolean status;
  static boolean[] checked;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    list = new ArrayList[n + 1];
    checked = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      list[i] = new ArrayList<>();
    }

    StringTokenizer st;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list[a].add(b);
      list[b].add(a);
    }

    count = 0;
    status = false;
    dfs(1, 0);

    for (int i = 2; i <= n; i++) {
      if (checked[i]) count++;
    }

    System.out.print(count);
  }

  private static void dfs(int now, int depth) {
    if (depth == 2) return;

    for (int i : list[now]) {
      checked[i] = true;
      dfs(i, depth + 1);
    }
  }
}
