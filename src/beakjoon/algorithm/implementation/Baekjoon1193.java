package beakjoon.algorithm.implementation;
/*
문제
- 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
    1/1 1/2 1/3 1/4 1/5 …
    2/1 2/2 2/3 2/4 …   …
    3/1 3/2 3/3 …   …   …
    4/1 4/2 …   …   …   …
    5/1 …   …   …   …   …
    …   …   …   …   …   …
  이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 
  지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
  X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.
출력
- 첫째 줄에 분수를 출력한다.
ex 1)
입력	출력
- 1     - 1/1
ex 2)
입력    출력
- 2     - 1/2
ex 3)
입력    출력
- 3     - 2/1
ex 4)
입력    출력
- 4     - 3/1
ex 5)
입력    출력
- 5     - 2/2
ex 6)
입력    출력
- 6     - 1/3
ex 7)
입력    출력
- 7     - 1/4
ex 8)
입력    출력
- 8     - 2/3
ex 9)
입력    출력
- 9     - 3/2
ex 10)
입력    출력
- 14    - 2/4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1193 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int cross_count = 1, prev_count_sum = 0;

    while (true) {
      // 직전 대각선 누적 합 + 해당 대각선 개수 이용한 범위 판별

      // 대각선의 개수가 홀수라면
      if (n <= prev_count_sum + cross_count) {
        // 분자가 큰 수부터 시작
        // 분자는 대각선상 블럭의 개수 - (n번째 - 직전 대각선까지의 블럭 개수 - 1)
        // 분모는 n번째 - 직전 대각선까지의 블럭 개수
        if (cross_count % 2 == 1) {
          System.out.println((cross_count - (n - prev_count_sum - 1)) + "/" + (n - prev_count_sum));
          break;

          // 대각선의 개수가 짝수라면
        } else {
          // 홀수일 때의 출력을 반대로
          System.out.println((n - prev_count_sum) + "/"+ (cross_count - (n - prev_count_sum - 1)));
          break;
        }
      } else {
        prev_count_sum += cross_count;
        cross_count++;
      }
    }
  }
}
