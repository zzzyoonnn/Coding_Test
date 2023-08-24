package beakjoon.algorithm.mathematics;
/*
문제
- 준하는 3의 거듭제곱인 수만 사용하여 만들 수 있는 수를 보면 삼삼한 느낌을 받는다.
  이 느낌을 정확히 설명하자면, 
  3의 거듭제곱인 수들을 겹치지 않고 한번씩만 더해서 어떤 수 x를 만들 수 있다면 그 수는 삼삼하다고 한다. 
  삼삼한 수는 3의 거듭제곱인 수가 반드시 하나 이상 포함되어야 한다.
  예를 들어, 109는 3^0+3^3+3^4로 나타낼 수 있으므로 삼삼한 수이다. 
  하지만 7과 18은 삼삼하지 않다.
  준하는 삼삼한 수가 얼마나 더 있는 지 알아보려고 한다.
입력
- 첫째 줄에 2,147,483,647보다 작거나 같은 음이 아닌 정수 N이 입력된다.
출력
- 입력된 수가 삼삼하다면 YES, 그렇지 않다면 NO를 출력한다.
ex 1)
입력      출력
- 109     - YES
ex 2)
입력      출력
- 298     - NO
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17252 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = Integer.toString(n, 3);
    boolean check = true;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '0' || c == '1') continue;
      else {
        check = false;
        break;
      }
    }
    if (n == 0) check = false;

    if (check) System.out.println("YES");
    else System.out.println("NO");
  }
}
