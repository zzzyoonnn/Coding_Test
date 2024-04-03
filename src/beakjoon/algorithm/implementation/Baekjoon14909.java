package beakjoon.algorithm.implementation;
/*
문제
- 주어진 N개의 정수 중에서 양의 정수의 개수를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 최대 1,000,000개의 정수가 주어진다. 입력으로 주어지는 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같다.
출력
- 첫째 줄에 양의 정수의 개수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14909 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int count = 0;

    while (st.hasMoreTokens()) {
      int n = Integer.parseInt(st.nextToken());

      if (n > 0) count++;
    }

    System.out.println(count);
  }
}
