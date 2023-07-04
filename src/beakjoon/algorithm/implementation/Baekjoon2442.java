package beakjoon.algorithm.implementation;
/*
문제
- 첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개를 찍는 문제
  별은 가운데를 기준으로 대칭이어야 한다.
입력
- 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
출력
- 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
ex 1)
입력
- 5
출력
-     *
 ***
 *****
 *******
 *********
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2442 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i; j++) {
        sb.append(" ");
      }
      for (int j = 1; j <= 2 * i - 1; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
