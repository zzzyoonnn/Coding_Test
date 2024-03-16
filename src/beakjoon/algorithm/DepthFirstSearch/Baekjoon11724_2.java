package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
  둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 
  같은 간선은 한 번만 주어진다.
출력
- 첫째 줄에 연결 요소의 개수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon11724_2 {
  static int n, m;
  static ArrayList<Integer>[] list;
  static boolean[] visited;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());   // 정점의 개수
    m = Integer.parseInt(st.nextToken());   // 간선의 개수

    list = new ArrayList[n + 1];

    for (int i = 0; i < n + 1; i++) list[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list[a].add(b);
      list[b].add(a);
    }

    visited = new boolean[n + 1];

    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        dfs(i);
        count++;
      }
    }
    System.out.println(count);
  }

  private static void dfs(int index) {
    visited[index] = true;

    for (int i : list[index]) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }
}
