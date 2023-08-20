package beakjoon.algorithm.mathematics;
/*
문제
- 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
입력
- 첫 줄에 수의 개수 N이 주어진다. 
  N은 100이하이다. 
  다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
출력
- 주어진 수들 중 소수의 개수를 출력한다.
ex 1)
입력	    출력
- 4         - 3
  1 3 5 7
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1978_1 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int count = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());

    while (st.hasMoreTokens()) {
      boolean check = true; // 소수인 경우 true
      int num = Integer.parseInt(st.nextToken());

      if (num == 1) continue;

      for (int i = 2; i < Math.sqrt(num); i++) {
        if (num % i == 0) {
          check = false;
          break;
        } else {
          System.out.println(num);
          break;
        }
      }
      if (check) {
        count++;
      }
    }
    System.out.println();
    System.out.println(count);
  }
}
