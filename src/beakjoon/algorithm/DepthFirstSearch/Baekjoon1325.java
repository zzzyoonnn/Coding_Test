package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon1325 {
  static int n, m, count = 0;
  static ArrayList<Integer>[] list;
  static int[] hack;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());   // the number of vertices
    m = Integer.parseInt(st.nextToken());   // the number of trunk lines

    list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

    hack = new int[n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list[b].add(a);
    }
    br.close();

    for (int i = 1; i <= n; i++) Collections.sort(list[i]);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      visited = new boolean[n + 1];
      count = 0;
      dfs(i);
      hack[i] = count;
      //sb.append(i).append(' ');
    }

    int max = Arrays.stream(hack).max().getAsInt();

    for (int i = 1; i <= n; i++) {
      if (hack[i] == max) sb.append(i).append(' ');
    }

    System.out.print(sb.toString());
  }

  private static void dfs(int index) {
    visited[index] = true;
    count++;
    //System.out.print(index + " ");

    for (int i : list[index]) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }
}
