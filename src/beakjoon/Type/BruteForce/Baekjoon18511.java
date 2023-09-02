package beakjoon.Type.BruteForce;
/*
문제
- N보다 작거나 같은 자연수 중에서, 집합 K의 원소로만 구성된 가장 큰 수를 출력하는 프로그램을 작성하시오. 
  K의 모든 원소는 1부터 9까지의 자연수로만 구성된다.
  예를 들어 N=657이고, K={1, 5, 7}일 때 답은 577이다.
입력
- 첫째 줄에 N, K의 원소의 개수가 공백을 기준으로 구분되어 자연수로 주어진다. 
  (10 ≤ N ≤ 100,000,000, 1 ≤ K의 원소의 개수 ≤ 3) 
  둘째 줄에 K의 원소들이 공백을 기준으로 구분되어 주어진다. 각 원소는 1부터 9까지의 자연수다.
  단, 항상 K의 원소로만 구성된 N보다 작거나 같은 자연수를 만들 수 있는 경우만 입력으로 주어진다.
출력
- 첫째 줄에 N보다 작거나 같은 자연수 중에서, K의 원소로만 구성된 가장 큰 수를 출력한다.
ex 1)
입력        출력
- 657 3     - 577
  1 5 7
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon18511 {

  private static Integer[] arr;
  private static int n;
  private static int k;
  private static int result;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new Integer[k];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr, Collections.reverseOrder());
    dfs(0);
    // DFS(깊이 우선 탐색) 알고리즘을 시작하기 위한 초기 호출
    // 초기에는 아무런 숫자도 조합되지 않았으므로 0을 넣어서 호출
    // 탐색의 시작점을 나타내며, 초기 호출을 통해 모든 가능한 조합을 찾아내고 최대값 구함
    System.out.println(result);
  }

  private static void dfs(int now) {    // now : 현재까지 조합된 숫자
    if (now > n) return;

    if (now > result) result = now;

    // 재귀적으로 가능한 모든 숫자 조합을 생성하고 탐색
    // 주어진 숫자 집합에서 가능한 모든 숫자 조합을 탐색하는 핵심 로직이며, 이를 통해 최댓값 찾음
    for (int i = 0; i < k; i++) {
      dfs(now * 10 + arr[i]);
    }
  }
}
