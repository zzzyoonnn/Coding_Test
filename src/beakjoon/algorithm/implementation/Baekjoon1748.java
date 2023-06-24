package beakjoon.algorithm.implementation;
/*
문제
- 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
    1234567891011121314151617181920212223...
  이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.
출력
- 첫째 줄에 새로운 수의 자릿수를 출력한다.
ex 1)
입력		출력
- 5         - 5
ex 2)
입력		출력
- 15        - 21
ex 3)
입력      출력
- 120        - 252
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1748 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int sum = 0;
    int count = 1;
    int length = 10;

    for (int i = 1; i <= n; i++) {
      if (i == length) {
        count++;
        length *= 10;
      }
      sum += count;
      System.out.println(sum + " " + count);
    }
    System.out.println(sum);
  }
}
