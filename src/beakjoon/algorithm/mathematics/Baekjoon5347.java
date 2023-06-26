package beakjoon.algorithm.mathematics;
/*
문제
- 두 수 a와 b가 주어졌을 때, a와 b의 최소 공배수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 테스트 케이스의 개수 n이 주어진다. 
  다음 n개 줄에는 a와 b가 주어진다. 
  a와 b사이에는 공백이 하나 이상 있다. 
  두 수는 백만보다 작거나 같은 자연수이다.
출력
- 각 테스트 케이스에 대해서 입력으로 주어진 두 수의 최소공배수를 출력한다.
ex 1)
입력      출력
- 3       - 105
  15 21     66
  33 22     90
  9 10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5347 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      System.out.println(lcm(a, b));
    }
  }

  public static int gcd(int x, int y) {
    if (x % y == 0) return y;
    return gcd(y, x % y);
  }

  public static int lcm(int x, int y) {
    return x * y / gcd(x, y);
  }
}
