package beakjoon.algorithm.implementation;
/*
문제
- 8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.
입력
- 첫째 줄에 8진수가 주어진다. 
  주어지는 수의 길이는 333,334을 넘지 않는다.
출력
- 첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 
  수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.
ex 1)
입력      출력
- 314     - 11001100
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1212 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    int n = Integer.parseInt(s, 8); // 8진수 -> 10진수로 변환

    System.out.println(Integer.toString(n, 2));
  }
}