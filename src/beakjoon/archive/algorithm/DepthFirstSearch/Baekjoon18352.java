package beakjoon.archive.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon18352 {
  static int n, m, k, x;
  static ArrayList<Integer>[] list;
  static int[] answer;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    list = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      list[start].add(end);
    }

    answer = new int[n + 1];
    Arrays.fill(answer, -1);
    sb = new StringBuilder();
    bfs(x);

    if (sb.length() == 0) System.out.print(-1);
    else System.out.print(sb.toString());
  }

  private static void bfs(int x) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(x);
    answer[x] = 0;

    while (!q.isEmpty()) {
      int now = q.poll();

      for (int i : list[now]) {
        if (answer[i] == -1) {
          answer[i] = answer[now] + 1;

          q.offer(i);
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      if (answer[i] == k) {
        sb.append(i).append("\n");
      }
    }
  }
}
