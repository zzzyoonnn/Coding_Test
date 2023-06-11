package beakjoon.algorithm.greedy;
/*
문제
- 정수 A를 B로 바꾸려고 한다. 
  가능한 연산은 다음과 같은 두 가지이다.
  - 2를 곱한다.
  - 1을 수의 가장 오른쪽에 추가한다. 
  A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
입력
- 첫째 줄에 A, B (1 ≤ A < B ≤ 10^9)가 주어진다.
출력
- A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 
  만들 수 없는 경우에는 -1을 출력한다.
ex 1)
입력        출력
- 2 162     - 5
ex 2)
입력        출력
- 4 42      - -1
ex 3)
입력            출력
- 100 40021     - 5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16953 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int cnt = 1;

    while (b != a) {
      if (b < a) {
        cnt = -1;
        break;
      }

      String s = String.valueOf(b);

      if (b % 2 == 0) {
        b /= 2;
      } else if (s.charAt(s.length() - 1) == '1') {
        s = s.substring(0, s.length() - 1);
        b = Integer.parseInt(s);
      } else {
        cnt = -1;
        break;
      }
      cnt++;
    }
    System.out.println(cnt);

  }
}
