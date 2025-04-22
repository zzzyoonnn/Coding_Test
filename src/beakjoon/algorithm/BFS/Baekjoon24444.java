package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon24444 {
  static int N, M, R;
  static int[] answer;
  static ArrayList<ArrayList<Integer>> list;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      list.add(new ArrayList<>());
    }
    answer = new int[N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      list.get(u).add(v);
      list.get(v).add(u);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(list.get(i));
    }

    bfs(R);

    for (int i = 1; i <= N; i++) {
      System.out.println(answer[i]);
    }
  }

  private static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    int turn = 1;
    answer[start] = turn;
    visited[start] = true;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int i : list.get(now)) {
        if (visited[i]) continue;

        queue.offer(i);
        visited[i] = true;
        answer[i] = ++turn;
      }
    }
  }
}
