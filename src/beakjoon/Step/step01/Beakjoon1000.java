package beakjoon.Step.step01;
/*
문제
- 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
출력
- 첫째 줄에 A+B를 출력한다.
ex 1)
입력          출력
- 1 2         - 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon1000 {
  // BufferedReader를 사용할 경우 예외처리 혹은 throws IOException을 해야 함
  public static void main(String[] args) throws IOException{
    int a, b;
    // 콘솔에서 입력받음
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    System.out.println(a + b);
  }
}
