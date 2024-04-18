package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1260 {
  static int n, m, v;
  static ArrayList<Integer> list[];
  static boolean[] visited;
  static StringBuilder sb;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();

    n = Integer.parseInt(st.nextToken());       // 정점의 개수
    m = Integer.parseInt(st.nextToken());       // 간선의 개수
    v = Integer.parseInt(st.nextToken());       // 탐색 시작 번호

    list = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list[a].add(b);
      list[b].add(a);
    }

    for (int i = 1; i <= n; i++) Collections.sort(list[i]);

    dfs(v);     // v부터 dfs 시작

    sb.append('\n');

    visited = new boolean[n + 1];       // 방문 확인 초기화

    bfs(v);     // v부터 bfs 시작

    System.out.println(sb);
  }

  private static void dfs(int index) {
    visited[index] = true;
    sb.append(index).append(' ');

    for (int i : list[index]) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }

  private static void bfs(int index) {
    // BFS에 사용할 큐 생성
    Queue<Integer> queue = new LinkedList<Integer>();

    queue.offer(index);     // BFS를 시작할 노드 삽입
    visited[index] = true;

    while(!queue.isEmpty()) {
      int num = queue.poll();
      sb.append(num).append(' ');

      for (int i : list[num]) {
        if (!visited[i]) {      // 방문하지 않았으면 방문처리 후 큐에 넣기
          visited[i] = true;
          queue.offer(i);
        }
      }
    }
  }
}
