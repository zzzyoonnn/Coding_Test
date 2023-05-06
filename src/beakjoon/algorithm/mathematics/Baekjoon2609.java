package beakjoon.algorithm.mathematics;
/*
문제
- 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에는 두 개의 자연수가 주어진다. 
  이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
출력
- 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 
  둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
ex 1)
입력      출력
- 24 18   - 6
            72
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2609 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int gcd = gcd(Math.max(a, b), Math.min(a, b));

    System.out.println(gcd);
    System.out.println(a * b / gcd);

  }

  public static int gcd (int a, int b) {
    if (a % b == 0) return b;
    return gcd(b, a % b);
  }
}
