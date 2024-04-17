package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2606_3 {
  static int n, m;
  static int count = 0;     // 컴퓨터에 연결된 컴퓨터 개수 세기용
  static ArrayList<Integer>[] list;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());        // 컴퓨터의 수
    m = Integer.parseInt(br.readLine());        // 컴퓨터 쌍의 수

    // 컴퓨터의 정보를 담을 ArrayList 초기화
    list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) list[i] = new ArrayList<Integer>();

    visited = new boolean[n + 1];       // 컴퓨터들의 방문 확인을 할 boolean[] 초기화

    // 네트워크 상에 연결된 컴퓨터 쌍을 ArrayList에 저장하기
    StringTokenizer st;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      list[u].add(v);
      list[v].add(u);
    }

    // 1번 컴퓨터에 연결된(1번 컴퓨터를 통해 웜 바이러스에 걸리게 될) 컴퓨터의 개수 출력
    System.out.println(dfs(1));
  }

  private static int dfs(int index) {
    visited[index] = true;      // index번 컴퓨터 방문 체크

    for (int i : list[index]) {     // index번 컴퓨터와 연결된 컴퓨터들 중, 방문되지 않은 컴퓨터를 찾아서 dfs 실행
      if (!visited[i]) {
        count++;
        dfs(i);
      }
    }

    return count;
  }
}
