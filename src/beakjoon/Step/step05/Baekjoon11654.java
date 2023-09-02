package beakjoon.Step.step05;
/*
문제
- 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때,
  주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
입력
- 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.
출력
- 입력으로 주어진 글자의 아스키 코드 값을 출력한다.
ex 1)
입력			출력
- A				- 65
ex 2)
입력			출력
- C				- 67
ex 3)
입력			출력
- 0				- 48
ex 1)
입력			출력
- 9				- 57
ex 2)
입력			출력
- a				- 97
ex 3)
입력			출력
- z				- 122
 */
import java.io.IOException;

public class Baekjoon11654 {
  public static void main(String[] args) throws IOException {
    // System.in : byte 값으로 문자 한개만 읽으면서
    // 해당 문자에 대응하는 아스키코드 값 저장
    int a = System.in.read();
    System.out.println(a);
  }
}
