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
import java.util.StringTokenizer;

public class Baekjoon11724 {
  static int n, m;
  static int[][] arr;
  static boolean[] visited;
  static int answer;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n + 1][n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a][b] = arr[b][a] = 1;
    }

    // 방문한 적이 없으면 dfs 실행
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        dfs(i);
        answer++;
      }
    }
    System.out.println(answer);
  }

  public static void dfs(int num) {
    visited[num] = true;
    for (int i = 1; i <= n; i++) {
      if (!visited[i] && arr[num][i] == 1) {
        dfs(i);
      }
    }
  }
}
