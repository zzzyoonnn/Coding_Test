package beakjoon.Type.BruteForce;
/*
문제
- 두 정수 n과 m이 주어졌을 때, 0 < a < b < n인 정수 쌍 (a, b) 중에서 
  (a2+b2+m)/(ab)가 정수인 쌍의 개수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
  각 테스트 케이스는 한 줄로 이루어져 있으며, n과 m이 주어진다. 
  두 수는 0보다 크고, 100보다 작거나 같다.
출력
- 각 테스트 케이스마다 문제의 조건을 만족하는 (a, b)쌍의 개수를 출력한다.
ex 1)
입력        출력
- 3         - 2
  10 1        4
  20 3        5
  30 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9094 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());    // 테스트 케이스 개수
    StringTokenizer st;

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int count = 0;
      for (int j = 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          if (((j * j) + (k * k) + m) % (j * k) == 0) count++;
        }
      }
      System.out.println(count);
    }
  }
}
