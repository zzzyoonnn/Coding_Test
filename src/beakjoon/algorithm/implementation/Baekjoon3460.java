package beakjoon.algorithm.implementation;
/*
문제
- 양의 정수 n이 주어졌을 때, 이를 이진수로 나타냈을 때 1의 위치를 모두 찾는 프로그램을 작성하시오. 
  최하위 비트(least significant bit, lsb)의 위치는 0이다.
입력
- 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
  각 테스트 케이스는 한 줄로 이루어져 있고, n이 주어진다. (1 ≤ T ≤ 10, 1 ≤ n ≤ 10^6)
출력
- 각 테스트 케이스에 대해서, 1의 위치를 공백으로 구분해서 줄 하나에 출력한다. 
  위치가 낮은 것부터 출력한다.
ex 1)
입력      출력
- 1       - 0 2 3
  13
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3460 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      String y = Integer.toBinaryString(x);
      for (int j = y.length() - 1; j >= 0; j--) {
        if (y.charAt(j) == '1') {
          System.out.print(y.length() - j - 1 + " ");
        }
      }
    }
  }
}