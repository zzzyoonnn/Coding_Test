package beakjoon.Step.step4;
/*
문제
- N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
  둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
  모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
출력
- 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
ex 1)
입력						출력
- 5							- 7 35
  20 10 35 30 7
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10818 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 수열의 크기
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    // 수열
    int index = 0;
    int[] arr = new int[n];

    // while문은 true면 while문 안의 문장 수행 false면 while문 종료
    // hasMoreToken()은 토큰이 존재하면 true 토큰 없으면 false
    while(st.hasMoreTokens()) {
      arr[index] = Integer.parseInt(st.nextToken());
      index++;
    }

    // Arrays.sort()는 오름차순 정렬
    Arrays.sort(arr);
    System.out.println(arr[0] + " " + arr[n - 1]);
  }
}
