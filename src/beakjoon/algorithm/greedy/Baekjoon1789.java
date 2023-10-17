package beakjoon.algorithm.greedy;
/*
문제
- 서로 다른 N개의 자연수의 합이 S라고 한다. 
  S를 알 때, 자연수 N의 최댓값은 얼마일까?
입력
- 첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
출력
- 첫째 줄에 자연수 N의 최댓값을 출력한다.
ex 1)
입력        출력
- 200       - 19
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1789 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    long sum = 0;
    int count = 0;

    for (int i = 1; ; i++) {
      if (sum > n) break;
      sum += i;
      count++;
    }
    System.out.println(count - 1);
  }
}
