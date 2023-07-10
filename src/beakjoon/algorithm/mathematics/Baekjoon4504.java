package beakjoon.algorithm.mathematics;
/*
문제
- 정수 n(0 < n < 1000)과 수의 목록이 주어졌을 때, 
  목록에 들어있는 수가 n의 배수인지 아닌지를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 n이 주어진다. 
  다음 줄부터 한 줄에 한 개씩 목록에 들어있는 수가 주어진다. 
  이 수는 0보다 크고, 10,000보다 작다. 목록은 0으로 끝난다.
출력
- 목록에 있는 수가 n의 배수인지 아닌지를 구한 뒤 예제 출력처럼 출력한다.
ex 1)
입력      출력
- 3       - 1 is NOT a multiple of 3.
  1         7 is NOT a multiple of 3.
  7         99 is a multiple of 3.
  99        321 is a multiple of 3.
  321       777 is a multiple of 3.
  777
  0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4504 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m;

    while ((m = Integer.parseInt(br.readLine())) != 0) {
      if (m % n == 0) System.out.println(m + " is a multiple of " + n + ".");
      else System.out.println(m + " is NOT a multiple of " + n + ".");
    }
  }
}
