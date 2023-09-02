package beakjoon.Step.step03;
/*
문제
- 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
  하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
입력
- 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
출력
- 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
ex 1)
입력
- 5
출력
-     *
 **
 ***
 ****
 *****
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2439 {
  public static void main(String[] args) throws IOException {
    int a;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    a = Integer.parseInt(br.readLine());

    for
    (int x = 1; x <= a; x++) {
      for (int y = 1; y <= a - x; y++) {
        System.out.printf(" ");
      }
      for (int z = 1; z <= x; z++) {
        System.out.printf("*");
      }
      System.out.println();
    }
  }
}
