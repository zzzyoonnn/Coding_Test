package beakjoon.algorithm.mathematics;
/*
문제
- 정수 N이 주어졌을 때, N의 제곱근을 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 양의 정수 N이 주어진다. 
  정수 N의 제곱근은 항상 정수이며, N의 길이는 800자리를 넘지 않는다.
출력
- 첫째 줄에 정수 N의 제곱근을 출력한다.
ex 1)
입력    출력
- 36    - 6
ex 2)
입력    출력
- 81    - 9
ex 1)
입력        출력
- 226576    - 476
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Baekjoon13706 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BigInteger n = new BigInteger(br.readLine());
    System.out.println(n.sqrt());
  }
}
