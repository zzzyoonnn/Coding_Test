package beakjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1068 {
  static ArrayList<Integer>[] graph;
  static boolean[] visited, leaf;
  static int n, removeNode;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new ArrayList[n];
    visited = new boolean[n];
    leaf = new boolean[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

    int parentNode = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int node = Integer.parseInt(st.nextToken());

      if (node == -1) {
        parentNode = i;
      } else {
        graph[node].add(i);
      }
    }

    removeNode = Integer.parseInt(br.readLine());

    graph[removeNode] = new ArrayList<>();


    if (parentNode != removeNode) {
      dfs(parentNode);
    }

    int count = 0;
    for (boolean b : leaf) {
      if (b) count++;
    }
    System.out.print(count);
  }

  private static void dfs(int index) {
    visited[index] = true;

    boolean isLeaf = true;

    int childCount = 0;

    for (int next : graph[index]) {
      if (next == removeNode) continue;

      if (!visited[next]) {
        childCount++;
        dfs(next);
      }
    }
    if (childCount == 0) {
      leaf[index] = true;
    }
  }
}
