package beakjoon.algorithm.implementation;
/*
문제
- 주어진 N개의 정수가 비내림차순으로 나열되어 있는지 판정하는 프로그램을 작성하시오. 
  N개의 수 A1, A2, ..., AN이 A1 ≤ A2 ≤ ... ≤ AN 을 만족하는 것을 비내림차순이라고 한다.
입력
- 첫째 줄에 공백으로 구분된 N(1 ≤ N ≤ 1,000,000)개의 정수가 주어진다. 
  입력으로 주어지는 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
출력
- 비내림차순으로 나열되어 있으면 Good을 출력하고, 그렇지 않으면 Bad을 출력한다.
ex 1)
입력      출력
- 7       - Good
ex 2)
입력          출력
- 1 2 3 4 5    - Good
ex 3)
입력          출력
- 1 2 2 2 4   - Good
ex 4)
입력      출력
- 2 1     - Bad
ex 5)
입력          출력
- 1 2 3 2 1   - Bad
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14910 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    boolean check = true;

    while (st.hasMoreTokens()) {
      int m = Integer.parseInt(st.nextToken());
      if (n <= m) n = m;
      else {
        check = false;
        break;
      }
    }

    if (check) System.out.println("Good");
    else System.out.println("Bad");
  }
}
