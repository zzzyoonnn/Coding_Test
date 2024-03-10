package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다. 
  이러한 촌수는 다음과 같은 방식으로 계산된다. 
  기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다. 
  예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 
  나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
  여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
입력
- 사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다. 
  입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 
  둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 
  그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 
  넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 
  이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
  각 사람의 부모는 최대 한 명만 주어진다.
출력
- 입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 
  어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 
  이때에는 -1을 출력해야 한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2644 {
  static int n, m;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();   // 양방향 인접 리스트

  static int find1, find2;
  static int answer = -1;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());    // 전체 사람의 수
    visited = new boolean[n + 1];

    for (int i = 0; i < n + 1; i++) graph.add(new ArrayList<>());

    StringTokenizer st = new StringTokenizer(br.readLine());
    find1 = Integer.parseInt(st.nextToken());   // 촌 수 계산해야 하는 사람 번호
    find2 = Integer.parseInt(st.nextToken());   // 촌 수 계산해야 하는 사람 번호

    m = Integer.parseInt(br.readLine());    // 부모 자식들 간의 관계의 개수

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());     // y의 부모
      int y = Integer.parseInt(st.nextToken());     // x의 자식

      // 양방향
      graph.get(x).add(y);
      graph.get(y).add(x);

      int count = 0;
      dfs(find1, count);

      System.out.println(answer);
    }
  }

  private static void dfs(int find1, int count) {
    visited[find1] = true;

    for (int i : graph.get(find1)) {
      if (!visited[i]) {    // 방문하지 않았으면
        if (i == find2) {
          answer = count + 1;
          return;
        }

        dfs(i, count + 1);  // 다음 촌수로 이동
      }
    }
  }
}
