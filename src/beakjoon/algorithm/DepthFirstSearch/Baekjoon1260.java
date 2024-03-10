package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
  단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
  더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
  정점 번호는 1번부터 N번까지이다.
입력
- 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
  다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
  어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
  입력으로 주어지는 간선은 양방향이다.
출력
- 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. 
  V부터 방문된 점을 순서대로 출력하면 된다.
 */
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
  static ArrayList<Integer>[] list;
  static boolean[] visited;
  static StringBuilder sb;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());   // 정점의 개수
    m = Integer.parseInt(st.nextToken());   // 간선의 개수
    v = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호
    list = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    sb = new StringBuilder();

    for (int i = 1; i < list.length; i++) list[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list[a].add(b);
      list[b].add(a);
    }

    for (int i = 1; i < list.length; i++) {
      Collections.sort(list[i]);    // 정점이 여러 개인 겨우, 정점 번호가 작은 것 부터 방문해야 하기 때문
    }

    dfs(v);

    sb.append('\n');

    visited = new boolean[n + 1];
    bfs(v);

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
    // 큐를 생성하여 시작 정점 삽입
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(index);
    visited[index] = true;

    while(!queue.isEmpty()) {
      // 큐에서 정점을 하나 꺼냄
      int num = queue.poll();
      // 해당 정점을 방문했다는 것을 표시하고 결과 문자열에 추가
      sb.append(num).append(' ');

      for (int i : list[num]) {     // 해당 정점과 인접한 정점들을 모두 확인
        if (!visited[i]) {
          // 인접한 정점이 아직 방문되지 않았다면 큐에 넣고 방문했다고 표시
          queue.offer(i);
          visited[i] = true;
        }
      }
    }
  }
}
