package beakjoon.algorithm.mathematics;
/*
문제
- 16진수 수를 입력받아서 10진수로 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 16진수 수가 주어진다. 이 수의 최대 길이는 6글자이다. 
  16진수 수는 0~9와 A~F로 이루어져 있고, A~F는 10~15를 뜻한다. 또, 이 수는 음이 아닌 정수이다.
출력
- 첫째 줄에 입력으로 주어진 16진수 수를 10진수로 변환해 출력한다.
ex 1)
입력      출력
- A       - 10
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1550 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    System.out.println(Integer.parseInt(s, 16));
  }
}
