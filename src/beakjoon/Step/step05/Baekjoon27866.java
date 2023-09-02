package beakjoon.Step.step05;
/*
문제
- 단어 S와 정수 i가 주어졌을 때, 
  S의 i번째 글자를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 영어 소문자와 대문자로만 이루어진 단어 S가 주어진다. 
  단어의 길이는 최대 1,000이다.
  둘째 줄에 정수 i가 주어진다. (1 <= i <=|S|)
출력
- S의 i번째 글자를 출력한다.
ex 1)
입력			출력
- Sprout        - r
  3
ex 2)
입력            출력
- shiftpsh      - p
  6
ex 3)
입력            출력
- Baekjoon      - k
  4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon27866 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int n = Integer.parseInt(br.readLine());

    System.out.println(str.charAt(n - 1));
  }
}
