package beakjoon.Step.step01;
/*
문제
- 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
출력
- 첫째 줄에 A/B를 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다.
ex 1)
입력          출력
- 1 3         - 0.33333333333333333333333333333333
ex 2)
입력          출력
- 4 5         - 0.8
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon1008 {
  public static void main(String[] args) throws IOException {
    double a, b;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    a = Double.parseDouble(st.nextToken());
    b = Double.parseDouble(st.nextToken());

    System.out.println(a / b);
  }
}
