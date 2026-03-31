package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj15900 {
  static int n, result;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  static class Node {
    int index;
    int depth;

    Node(int index, int depth) {
      this.index = index;
      this.depth = depth;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

    StringTokenizer st;
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    result = 0;
    bfs(1, 0);

    System.out.print(result % 2 == 0 ? "No" : "Yes");
  }

  private static void bfs(int index, int depth) {
    visited[index] = true;
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(index, depth));


    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      boolean isLeaf = true;

      for (int next : graph[cur.index]) {
        if (!visited[next]) {
          visited[next] = true;
          isLeaf = false;
          queue.add(new Node(next, cur.depth + 1));
        }
      }
      if (isLeaf) result += cur.depth;
    }
  }
}
