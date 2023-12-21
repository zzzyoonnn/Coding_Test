package beakjoon.algorithm.implementation;
/*
문제
- 아래 예제 출력과 같은 J박스를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 테스트 케이스의 개수가 주어진다. 
  각 테스트 케이스는 한 줄로 이루어져 있고, 박스의 크기가 주어진다. 
  박스의 크기는 10보다 작거나 같다.
출력
- 각 테스트 케이스에 대해서, 입력으로 주어지는 크기의 J박스를 출력한다. 
  박스와 박스 사이에는 빈 줄을 하나 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5354 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int m = Integer.parseInt(br.readLine());
      for (int line = 0; line < m; line++) {
        for (int j = 0; j < m; j++) {
          if (line == 0 || line == m - 1 || j == 0 || j == m - 1) sb.append('#');
          else sb.append('J');
        }
        sb.append('\n');
      }
      sb.append('\n');
    }
    System.out.print(sb);
  }
}
