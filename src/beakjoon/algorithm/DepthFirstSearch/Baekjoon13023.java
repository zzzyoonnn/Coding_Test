package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon13023 {
  static int N, M;
  static int result;
  static boolean[] visited;
  static ArrayList<Integer>[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());   // 사람 수
    M = Integer.parseInt(st.nextToken());   // 친구 관계 수

    list = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list[a].add(b);
      list[b].add(a);
    }

    result = 0;
    for (int i = 0; i < N; i++) {
      visited = new boolean[N];
      dfs(i, 0);

      if (result == 1) break;
    }

    System.out.print(result);
  }

  private static void dfs(int cur, int depth) {
    if (depth == 4) {
      result = 1;
      return;
    }

    visited[cur] = true;
    for (int i : list[cur]) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(i, depth + 1);
        visited[i] = false;
      }
    }
    visited[cur] = false;
  }
}
