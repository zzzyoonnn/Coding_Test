package beakjoon.Step.step13;
/*
문제
- 분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다.
  A와 B는 모두 자연수라고 하자.
  두 분수의 합 또한 분수로 표현할 수 있다. 
  두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오. 
  기약분수란 더 이상 약분되지 않는 분수를 의미한다.
입력
- 첫째 줄과 둘째 줄에, 각 분수의 분자와 분모를 뜻하는 두 개의 자연수가 순서대로 주어진다. 
  입력되는 네 자연수는 모두 30,000 이하이다.
출력
- 첫째 줄에 구하고자 하는 기약분수의 분자와 분모를 뜻하는 두 개의 자연수를 빈 칸을 사이에 두고 순서대로 출력한다.
ex 1)
입력		출력
- 2 7		- 31 35
  3 5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1735 {

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 공백 기준으로 토큰화(한번에 입력받음)
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());	// 분자
    int b = Integer.parseInt(st.nextToken());	// 분모

    st = new StringTokenizer(br.readLine());
    int c = Integer.parseInt(st.nextToken());	// 분자
    int d = Integer.parseInt(st.nextToken());	// 분모

    int x = (a * d) + (b * c);	// 분자
    int y = b * d;	// 분모

    // 분자 최종
    int numerator = x / gcd(x, y);
    // 분모 최종
    int denominator = y / gcd(x, y);

    System.out.printf("%d %d",numerator, denominator);
  }

  // 최대공약수 GCD(Greatest Common Divisior)
  public static int gcd(int a, int b) {
    if (a % b == 0) return b;	// 최대공약수는 두 개의 a, b에 대해서 b와 a % b의 값이 최대공약수와 같으므로 리턴값으로 재귀 사용
    return gcd(b, a % b);
  }


}
