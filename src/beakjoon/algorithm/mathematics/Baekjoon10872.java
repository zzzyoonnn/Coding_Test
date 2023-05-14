package beakjoon.algorithm.mathematics;
/*
문제
- 0보다 크거나 같은 정수 N이 주어진다. 
  이때, N!을 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
출력
- 첫째 줄에 N!을 출력한다.
ex 1)
입력      출력
- 10      - 3628800
ex 2)
입력      출력
- 0       - 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10872 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int result = 1;

    if (n != 0) {
      for (int i = n; i > 0; i--) result *= i;
    } else result = 1;

    System.out.println(result);
  }
}
