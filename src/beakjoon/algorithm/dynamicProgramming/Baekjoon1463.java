package beakjoon.algorithm.DynamicProgramming;
/*
문제
- 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
    1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
    2. X가 2로 나누어 떨어지면, 2로 나눈다.
    3. 1을 뺀다.
  정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
  연산을 사용하는 횟수의 최솟값을 출력하시오.
입력
- 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
출력
- 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
ex 1)
입력	출력
- 2     - 1
ex 2)
입력    출력
- 10    - 3
 */
import java.util.Scanner;

public class Baekjoon1463 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n + 1];

    arr[0] = 0;
    arr[1] = 0;

    for (int i = 2; i < n + 1; i++) {
      if (i % 6 == 0) {
        arr[i] = Math.min(arr[i / 2] + 1, arr[i / 3] + 1);
      } else if (i % 2 == 0) {
        arr[i] = Math.min(arr[i - 1] + 1, arr[i / 2] + 1);
      } else if (i % 3 == 0) {
        arr[i] = Math.min(arr[i - 1] + 1, arr[i / 3] + 1);
      } else {
        arr[i] = arr[i - 1] + 1;
      }
    }
    System.out.println(arr[n]);
  }
}
