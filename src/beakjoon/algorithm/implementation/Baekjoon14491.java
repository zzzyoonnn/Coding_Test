package beakjoon.algorithm.implementation;
/*
문제
- 10진수를 9진수로 바꾸자.
입력
- 첫째 줄에 10진수 T(1 ≤ T ≤ 10,000)가 주어진다.
출력
- T를 9진수로 변환한 수를 출력한다.
ex 1)
입력        출력
- 100       - 121
 */
import java.util.Scanner;

public class Baekjoon14491 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(Integer.toString(n, 9));
  }
}