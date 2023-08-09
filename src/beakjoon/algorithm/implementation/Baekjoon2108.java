package beakjoon.algorithm.implementation;
/*
문제
- 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 
  통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 
  단, N은 홀수라고 가정하자.
    산술평균 : N개의 수들의 합을 N으로 나눈 값
    중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    최빈값 : N개의 수들 중 가장 많이 나타나는 값
    범위 : N개의 수들 중 최댓값과 최솟값의 차이
  N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 
  단, N은 홀수이다. 
  그 다음 N개의 줄에는 정수들이 주어진다. 
  입력되는 정수의 절댓값은 4,000을 넘지 않는다.
출력
- 첫째 줄에는 산술평균을 출력한다. 
  소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
  둘째 줄에는 중앙값을 출력한다.
  셋째 줄에는 최빈값을 출력한다. 
  여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
  넷째 줄에는 범위를 출력한다.
ex 1)
입력      출력
- 5       - 2
  1         2
  3         1
  8         10
  -2
  2
ex 2)
입력      출력
- 1       - 4000
  4000      4000
            4000
            0
ex 2)
입력      출력
- 5       - 0
  -1        0
  -2        0
  -3        1
  -1
  -2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2108 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int sum = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sum += arr[i];
    }

    Arrays.sort(arr);

    int max = -1;    // third
    int count = 0;  // third
    int mod = arr[0];   // third
    boolean check = false;  // third

    for (int i = 0; i < n - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        count++;
      } else {
        count = 0;
      }

      if (max < count) {
        max = count;
        mod = arr[i];
        check = true;
      } else if (max == count && check == true) {
        mod = arr[i];
        check = false;
      }
    }

    System.out.println(sum / n);    // first
    System.out.println(arr[arr.length / 2]);    // second
    System.out.println(mod);    // third
    System.out.println(arr[arr.length - 1] - arr[0]);   // fourth
  }
}