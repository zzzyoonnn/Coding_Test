package beakjoon.algorithm.implementation;
/*
문제
- 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 A, 둘째 줄에 B가 주어진다. (0 < A, B < 10)
출력
- 첫째 줄에 A+B를 출력한다.
ex 1)
입력      출력
- 1       - 3
  2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2558 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());

    System.out.println(a + b);
  }
}
