package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 오늘도 서준이는 깊이 우선 탐색(DFS) 수업 조교를 하고 있다. 
  아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
  N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다.
  정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다. 
  정점 R에서 시작하여 깊이 우선 탐색으로 만들어 지는 트리를 깊이 우선 탐색 트리라고 하자. 
  깊이 우선 탐색 트리에 있는 모든 노드의 깊이(depth)를 출력하자. 
  시작 정점 R의 깊이는 0이고 방문 되지 않는 노드의 깊이는 -1로 출력하자.
  깊이 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 오름차순으로 방문한다.
입력
- 첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.
  다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다. (1 ≤ u < v ≤ N, u ≠ v) 
  모든 간선의 (u, v) 쌍의 값은 서로 다르다.
출력
- 첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다. 
  i번째 줄에는 정점 i의 깊이를 출력한다. 
  시작 정점 R의 깊이는 0이고 방문 되지 않는 노드의 깊이는 -1로 출력하자.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon24481 {
  static int n, m, r;
  static int[] depth;
  static List<Integer>[] list;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      list[u].add(v);
      list[v].add(u);
    }

    for (int i = 1; i <= n; i++) Collections.sort(list[i]);

    boolean[] visited = new boolean[n + 1];
    visited[r] = true;

    depth = new int[n + 1];
    for (int i = 1; i <= n; i++) depth[i] = -1;
    depth[r] = 0;
    dfs(r, visited, 1);

    for (int i = 1; i <= n; i++) System.out.println(depth[i]);
  }

  private static void dfs(int i, boolean[] visited, int count) {
    if (list[i].size() == 0) return;

    for (int j : list[i]) {
      if (!visited[j]) {
        visited[j] = true;
        depth[j] = count;
        dfs(j, visited, count + 1);
      }
    }
  }
}
