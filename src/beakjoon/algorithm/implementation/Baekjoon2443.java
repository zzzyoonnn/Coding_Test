package beakjoon.algorithm.implementation;
/*
문제
- 첫째 줄에는 별 2×N-1개, 둘째 줄에는 별 2×N-3개, ..., N번째 줄에는 별 1개를 찍는 문제
  별은 가운데를 기준으로 대칭이어야 한다.
입력
- 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
출력
- 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
ex 1)
입력
- 5
출력
- *********
 *******
 *****
 ***
 *
 */
import java.util.Scanner;

public class Baekjoon2443 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) System.out.print(" ");
      for (int j = n - i; j > 0; j--) System.out.print("*");
      for (int j = 0; j < n - i - 1; j++) System.out.print("*");
      System.out.println();
    }
  }
}
