package beakjoon.algorithm.GraphTheory;
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
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1260 {
  static int[][] check;     // 간선 연결 상태
  static boolean[] visited;     // 확인 여부
  static int n;     // 정점 개수
  static int m;    // 간선 개수
  static int start;     // 시작 정점

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());

    check = new int[n + 1][n + 1];      // 좌표 그대로 받아들이기 위해 +1
    visited = new boolean[n + 1];       // node가 1부터 시작하기 때문에 n + 1

    // 간선 연결상태 저장
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      // 연결된 노드를 1로 세팅
      check[a][b] = check[b][a] = 1;
    }

    dfs(start);

    visited = new boolean[n + 1];   // 방문한 노드 초기화
    System.out.println();

    bfs(start);
  }

  // 시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
  private static void dfs(int i) {
    visited[i] = true;
    System.out.print(i + " ");

    if (i == check.length) return;

    for (int j = 1; j <= n; j++) {
      // 연결된 노드인데 방문되지 않은 경우
      if (check[i][j] == 1 && visited[j] == false) {
        // 연결된 노드 찾으면 재귀함수 호출
        dfs(j);
      }
    }
  }

  private static void bfs(int i) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(i);
    visited[i] = true;

    System.out.print(i + " ");

    while (!queue.isEmpty()) {
      int n = queue.poll();

      // 노드 하나로 연결된 노드 먼저 다 체크
      for (int j = 1; j < check.length; j++) {
        // 연결된 노드인데 방문하지 않은 경우
        if (check[n][j] == 1 && visited[j] == false) {
          visited[j] = true;
          System.out.print(j + " ");
          queue.offer(j);
        }
      }
    }
  }
}
