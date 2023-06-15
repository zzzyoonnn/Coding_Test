package beakjoon.algorithm.implementation;
/*
문제
- 마이크로소프트 로고를 예제 출력처럼 출력하는 프로그램을 작성하시오.
입력
- 마이크로소프트 로고를 예제 출력처럼 출력한다.
출력
- 첫째 줄에 두 유명도의 차이 (|N-M|)을 출력한다.
ex 1)
출력
-        _.-;;-._
  '-..-'|   ||   |
  '-..-'|_.-;;-._|
  '-..-'|   ||   |
  '-..-'|_.-''-._|
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5338 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("       _.-;;-._");
    System.out.println("'-..-'|   ||   |");
    System.out.println("'-..-'|_.-;;-._|");
    System.out.println("'-..-'|   ||   |");
    System.out.println("'-..-'|_.-''-._|");
  }
}
