package beakjoon.algorithm.implementation;
/*
문제
- 1부터 N - 1까지의 정수가 하나씩 정렬되지 않은 채로 저장되어 있는 어떤 수열 A가 있다. 
  수열 A에 임의의 정수 M(1 ≤ M ≤ N – 1)을 넣어 크기가 N인 수열로 만들었을 때, 
  임의의 정수 M을 찾는 프로그램을 작성하라.
입력
- 첫째 줄에 수열의 크기 N(2 ≤ N ≤ 10,000,000)이 주어진다.
  둘째 줄에 수열 A의 원소인 N개의 정수가 주어진다. 
  입력으로 주어지는 정수는 모두 1보다 크거나 같고, N-1보다 작거나 같은 정수이며 문제의 답인 M을 제외하고는 모두 서로 다른 정수이다.
출력
- M을 출력하라.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15719 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < arr.length; i++) {
      int num = Integer.parseInt(st.nextToken());
      arr[num]++;
      if (arr[num] > 1) System.out.println(num);
    }
  }
}
