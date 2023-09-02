package beakjoon.Step.step01;
/*
문제
- 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 
입력
- 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
출력
- 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
ex 1)
입력
- 7 3
출력
- 10
  4
  21
  2
  1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10869 {
  public static void main(String[] args) throws IOException {
    int a, b;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    System.out.println(a + b);
    System.out.println(a - b);
    System.out.println(a * b);
    System.out.println(a / b);
    System.out.println(a % b);
  }
}
