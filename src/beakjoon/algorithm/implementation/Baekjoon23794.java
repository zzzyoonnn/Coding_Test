package beakjoon.algorithm.implementation;
/*
문제
- 첫째 줄과 N+2번째 줄에는 골뱅이 N+2개를 출력한다.
  둘째 줄부터 N+1번째 줄까지는 예제 출력과 같은 방식으로 골뱅이 2개와 공백 N개를 출력한다.
입력
- 첫째 줄에 정수 N(1 <= N <= 100)이 주어진다.
출력
- 첫째 줄부터 N+2번째 줄까지 차례대로 골뱅이를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon23794 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n + 2; i++) System.out.print("@");

    System.out.println();

    for (int i = 0; i < n; i++) {
      System.out.print("@");
      for (int j = 0; j < n; j++) System.out.print(" ");
      System.out.println("@");
    }

    for (int i = 0; i < n + 2; i++) System.out.print("@");
  }
}
