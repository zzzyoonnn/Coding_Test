package beakjoon.algorithm.greedy;
/*
문제
- 옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 
  이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
  길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
    S = A[0] × B[0] + ... + A[N-1] × B[N-1]
  S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 
  단, B에 있는 수는 재배열하면 안 된다.
  S의 최솟값을 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 N이 주어진다. 
  둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 
  셋째 줄에는 B에 있는 수가 순서대로 주어진다. 
  N은 50보다 작거나 같은 자연수이고, 
  A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
  가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
출력
- 첫째 줄에 S의 최솟값을 출력한다.
ex 1)
입력          출력
- 5           - 18
  1 1 1 6 0
  2 7 8 3 1
ex 2)
입력          출력
- 3           - 80
  1 1 3
  10 30 20
ex 3)
입력          출력
- 9           - 528
  5 15 100 31 39 0 0 3 26
  11 12 13 2 3 4 5 9 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1026 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int [] a = new int[n];
    int [] b = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(a);
    Arrays.sort(b);

    int [] c = new int[n];
    for (int i = 0; i < n; i++) {
      c[i] = a[n - i - 1];
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += b[i] * c[i];
    }

    System.out.println(sum);
  }
}
