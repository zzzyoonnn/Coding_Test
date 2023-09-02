package beakjoon.Step.step4;
/*
문제
- 정수 N개로 이루어진 수열 A와 정수 X가 주어진다.
  이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
  둘째 줄에 수열 A를 이루는 정수 N개가 주어진다.
  주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
출력
- X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다.
  X보다 작은 수는 적어도 하나 존재한다.
ex 1)
입력						출력
- 10 5						- 1 4 2 3
  1 10 4 9 2 3 8 5 7 6
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10871 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 수열의 갯수
    int n = Integer.parseInt(st.nextToken());
    // 구할 작은수의 기준
    int criteria = Integer.parseInt(st.nextToken());


    // 수열
    // StringBuilder는 String과 문자열을 더할 때 새로운 객체를 생성하는 것이 아니라
    // 기존의 데이터에 더하는 방식
    StringBuilder sb = new StringBuilder();
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      int element = Integer.parseInt(st.nextToken());

      if (element < criteria) {
        // append를 사용하여 문자열 더함
        sb.append(element).append(' ');
      }
    }
    System.out.println(sb);
  }
}
