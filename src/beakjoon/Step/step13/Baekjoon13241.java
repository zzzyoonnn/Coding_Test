package beakjoon.Step.step13;
/*
문제
- 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다.
  이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다.
  예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
  두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
  둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)
출력
- 첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.
ex 1)
입력		출력
- 3			- 45000
  1 45000	  30
  6 10		  221
  13 17
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon13241 {

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 입력받은 문자열을 Integer 데이터타입으로 변환(기본형 String)
    // n 은 테스트 케이스 갯수
    int n = Integer.parseInt(br.readLine());

    // 문자들을 입력받아 String을 만들 StringBuilder 선언
    // String은 불변의 객체이기 때문에
    // 새로 만들거나 합칠 때마다
    // 새로운 문자열을 참조하기에 비효율적
    //StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      // 공백 기준으로 토큰화(한번에 입력받음)
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());


      // String 토큰들을 Integer로 형변환
      //sb.append(a * b / getGCD(a, b)).append('\n');
      bw.write(lcm(a, b)+"\n");
    }

    bw.flush();
    bw.close();
  }

  // 최대공약수 GCD(Greatest Common Divisior)
  public static int gcd(int a, int b) {
    if (a % b == 0) return b;	// 최대공약수는 두 개의 a, b에 대해서 b와 a % b의 값이 최대공약수와 같으므로 리턴값으로 재귀 사용
    return gcd(b, a % b);
  }

  // 최소공배수 LCM(Least Common Multiple)
  public static int lcm(int x, int y) {
    return x * y / gcd(x, y);
  }

}
