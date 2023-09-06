package beakjoon.Type.Implementation;
/*
문제
- N개의 정수가 주어진다. 
  이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 10)가 주어진다. 
  각 테스트 케이스는 두 줄로 이루어져 있다.
  각 테스트 케이스의 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 
  둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
  모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
출력
- 각 테스트 케이스마다 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 한 줄에 하나씩 차례대로 출력한다.
ex 1)
입력                출력
- 3                 - 20 28
  5                   17 30
  20 28 22 25 21      7 35
  5
  30 21 17 25 29
  5
  20 10 35 30 7
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon20053 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      int m = Integer.parseInt(br.readLine());
      int[] arr = new int[m];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);
      System.out.println(arr[0] + " " + arr[m - 1]);
    }
  }
}
