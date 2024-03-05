package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 루트 없는 트리가 주어진다. 
  이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 
  둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
출력
- 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon11725 {
  static int n;     // 노드의 개수
  static int[] parent;
  static boolean[] visited;
  static ArrayList<Integer> list[];

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    parent = new int[n + 1];
    list = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i < n + 1; i++) list[i] = new ArrayList<>();

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list[a].add(b);
      list[b].add(a);
    }

    dfs(1);

    for (int i = 2; i < parent.length; i++) {
      System.out.println(parent[i]);
    }
  }

  private static void dfs(int index) {
    visited[index] = true;

    for (int i : list[index]) {
      if (!visited[i]) {
        parent[i] = index;
        dfs(i);
      }
    }
  }
}
