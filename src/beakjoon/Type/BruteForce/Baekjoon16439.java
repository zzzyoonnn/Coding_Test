package beakjoon.Type.BruteForce;
/*
문제
- N명의 고리 회원들은 치킨을 주문하고자 합니다.
  치킨은 총 M가지 종류가 있고 회원마다 특정 치킨의 선호도가 있습니다. 
  한 사람의 만족도는 시킨 치킨 중에서 선호도가 가장 큰 값으로 결정됩니다. 
  진수는 회원들의 만족도의 합이 최대가 되도록 치킨을 주문하고자 합니다.
  시키는 치킨의 종류가 많아질수록 치킨을 튀기는 데에 걸리는 시간도 길어지기 때문에 
  최대 세 가지 종류의 치킨만 시키고자 합니다.
  진수를 도와 가능한 만족도의 합의 최댓값을 구해주세요.
입력
- 첫 번째 줄에 고리 회원의 수 N (1 ≤ N ≤ 30) 과 치킨 종류의 수 M (3 ≤ M ≤ 30) 이 주어집니다.
  두 번째 줄부터 N개의 줄에 각 회원의 치킨 선호도가 주어집니다.
  i+1번째 줄에는 i번째 회원의 선호도 ai1, ai2, ..., aiM (1 ≤ aij ≤ 9) 가 주어집니다.
출력
- 첫 번째 줄에 고리 회원들의 만족도의 합의 최댓값을 출력합니다.
ex 1)
입력          출력
- 3 5         - 13
  1 2 3 4 5
  5 4 3 2 1
  1 2 3 2 1
ex 2)
입력            출력
- 4 6           - 25
  1 2 3 4 5 6
  6 5 4 3 2 1
  3 2 7 9 2 5
  4 5 6 3 2 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16439 {
  static int n;     // 회원 수
  static int m;     // 치킨의 종류
  static int max = 0;
  static int[][] chicken;
  static boolean preference[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    chicken = new int[n][m];
    preference = new boolean[m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        chicken[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0);
    System.out.println(max);
  }

  static void dfs(int depth, int start) {
    // m 종류의 치킨 중 3개의 치킨이 선택됬다면
    if (depth == 3) {
      int sum = 0;

      // 각 회원마다 선택된 3종류의 치킨 중 가장 선호도가 높은 치킨을 선택하고
      // 그 누적 합을 구해 최댓값 갱신
      for (int i = 0; i < n; i++) {
        int num = 0;
        for (int j = 0; j < m; j++) {
          // 선택된 치킨 중 가장 선호도가 높은 치킨 찾기
          if (preference[j]) num = Math.max(num, chicken[i][j]);
        }
        sum += num;
      }
      max = Math.max(max, sum);
      return;
    }

    // m개의 치킨 중 3개의 치킨을 중복 없이 선택
    for (int i = start; i < m; i++) {
      if (!preference[i]) {
        preference[i] = true;

        // 재귀 호출 수행
        // 백트래킹 알고리즘에서 핵심 역할
        // 자기 자신을 호출함으로써 다음 단계로 넘어가고, 새로운 치킨 선택
        // depth = 현재까지 선택한 치킨의 수
        // i = 현재 선택한 치킨의 인덱스
        // 이러한 방식으로 모든 가능한 치킨 조합 탐색 가능
        // 중복 없이 3가지 종류의 치킨 선택
        dfs(depth + 1, i + 1);
        preference[i] = false;
      }
    }
  }
}