package beakjoon.algorithm.implementation;
/*
문제
- 자연수 N과 정수 K가 주어졌을 때 이항 계수 (N K)를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)
출력
- (N K)를 출력한다.
ex 1)
입력      출력
- 5 2     - 10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11050 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int up = 1;
    int down = 1;

    for (int i = 0; i < k; i++) {
      up *= (n - i);
      down *= (i + 1);
    }
    System.out.println(up / down);
  }
}
