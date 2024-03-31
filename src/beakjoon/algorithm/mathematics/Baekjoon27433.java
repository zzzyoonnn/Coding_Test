package beakjoon.algorithm.mathematics;
/*
문제
- 0보다 크거나 같은 정수 N이 주어진다. 
  이때, N!을 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 정수 N(0 ≤ N ≤ 20)이 주어진다.
출력
- 첫째 줄에 N!을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon27433 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    long factorial = 1;

    for (int i = 1; i <= n; i++) {
      factorial *= i;
    }

    System.out.println(factorial);

  }
}
