package beakjoon.algorithm.mathematics;
/*
문제
- 에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.
  이 알고리즘은 다음과 같다.
    1. 2부터 N까지 모든 정수를 적는다.
    2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
    3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
    4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
  N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 N과 K가 주어진다. (1 ≤ K < N, max(1, K) < N ≤ 1000)
출력
- 첫째 줄에 K번째 지워진 수를 출력한다.
ex 1)
입력      출력
- 7 3     - 6
ex 1)
입력      출력
- 15 12   - 7
ex 1)
입력      출력
- 10 7    - 9
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2960 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    boolean[] check = new boolean[n + 1];   // 소수 여부를 체크하기 위한 boolean 배열 생성
    // 배열의 인덱스가 소수인지 여부를 나타내며, 초기에는 모두 false로 초기화

    int count = 0;  // 지워진 수의 개수를 세기 위한 변수 초기화
    for (int i = 2; i <= n; i++) {  // 에라토스테네스의 체 알고리즘의 핵심
      for (int j = i; j <= n; j += i) { // i 배수들을 지워나감
        if (check[j] == false) {    // j가 지워지지 않은 수라면
          count++;  // count를 증가시키고, j를 지워진 수로 체크
          check[j] = true;
        }

        if (count == k) {
          System.out.println(j);
          System.exit(0);   // 프로그램 종료
        }
      }
    }
  }
}
