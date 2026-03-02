package beakjoon.archive.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2644_1 {
  static int n, m, result;
  static ArrayList<Integer>[] list;
  static boolean[] checked;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    list = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();
    checked = new boolean[n + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      list[x].add(y);
      list[y].add(x);
    }

    result = -1;
    dfs(a, b, 0);

    System.out.print(result);
  }

  private static void dfs(int a, int b, int count) {
    checked[a] = true;

    if (a == b) {
      result = count;
      return;
    }

    for (int i : list[a]) {
      if (!checked[i]) {
        checked[i] = true;
        dfs(i, b, count + 1);
      }
    }
  }
}
