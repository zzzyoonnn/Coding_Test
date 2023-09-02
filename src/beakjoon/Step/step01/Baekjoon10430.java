package beakjoon.Step.step01;
/*
문제
- (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
  (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
  세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
출력
- 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
ex 1)
입력
- 5 8 4
출력
- 1
  1
  0
  0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10430 {
  public static void main(String[] agrs) throws IOException {
    int a, b, c;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    System.out.println((a + b) % c);
    System.out.println(((a % c) + (b % c)) % c);
    System.out.println((a * b) % c);
    System.out.println(((a % c) * (b % c)) % c);
  }
}
