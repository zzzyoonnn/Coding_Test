package beakjoon.algorithm.arithmetic;
/*
문제
- 두 정수 a와 b 최소공배수는 두 수의 공통된 배수 중 가장 작은 수이고, 
  최대공약수는 두 수의 공통된 약수중 가장 큰 수이다.
  a와 b가 주어졌을 때, 최소공배수와 최대공약수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 테스트 케이스의 개수 T(1<=T<=1,000)가 주어진다. 
  각 테스트 케이스는 두 정수 a와 b로 이루어져 있고, 공백으로 구분되어 있다. (1 <= a,b <= 1,000)
출력
- 각 테스트 케이스에 대해 최소공배수와 최대공약수를 차례대로 출력한다.
ex 1)
입력      출력
- 3       - 10 5
  5 10      161 1
  7 23      168 14
  42 56
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2702 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      System.out.println(lcm(a, b) + " " + gcd(a, b));
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
