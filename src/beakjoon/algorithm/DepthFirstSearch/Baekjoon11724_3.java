package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon11724_3 {
  static int n, m;
  static boolean[] visited;
  static ArrayList<Integer> list[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());       // 정점의 개수
    m = Integer.parseInt(st.nextToken());       // 간선의 개수

    // 정점간의 연결 정보를 담을 ArrayList 초기화
    list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

    // 방문 여부를 확인할 boolean[] 배열 초기화
    visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      // ArrayList에 정점의 연결 요소 정보 저장
      list[u].add(v);
      list[v].add(u);
    }

    int count = 0;      // 연결 요소의 개수 세기용
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {        // 방문되지 않은 정점이라면
        dfs(i);                 // dfs 실시
        count++;                // 연결 요소 개수 + 1;
      }
    }

    System.out.println(count);
  }

  private static void dfs(int index) {
    visited[index] = true;      // 방문되었음을 표시

    // list[index]의 연결 요소 깊이우선탐색 실시
    for (int i : list[index]) {
      if (!visited[i]) {        // 방문되지 않은 정점이라면
        dfs(i);                 // dfs 실시
      }
    }
  }
}
