package beakjoon.algorithm.mathematics;
/*
문제
- 2021년, 홍익대학교는 절대평가를 시행한다. 
  착한 도현이는 A학점을 받는 사람이 최대한 많았으면 한다.
  시험을 응시한 학생의 수 N, 상대평가 시 A학점의 비율 X%와 절대평가 시 A학점을 받기 위한 최소 점수 Y점이 주어질 때, 
  상대평가 시 A학점을 받는 인원의 수와 절대평가 시 A학점을 받는 인원의 수를 구하는 프로그램을 작성해보자.
입력
- 첫째 줄에 시험을 응시한 학생의 수 정수 N (10 <= N <= 100, N은 10의 배수) 이 주어진다.
  둘째 줄에 길이가 N인 정수 수열 A (1 <= A_i <= 100)가 공백을 기준으로 주어진다. 
  i번째로 주어지는 수 Ai는 i번째 학생의 점수이다. 
  모든 학생의 점수는 다르다.
  셋째 줄에 상대평가 시 A학점의 비율 X (10 <= X <= 100, X는 10의 배수)와 
  절대평가 시 A학점을 받기 위한 최소 점수 Y (1 <= Y <= 100)가 정수로 주어진다.
출력
- 첫째 줄에 상대평가 시 A학점을 받는 인원의 수와 절대평가 시 A학점을 받는 인원의 수를 공백으로 구분해 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon23320 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    int sum = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum += arr[i];
    }

    st = new StringTokenizer(br.readLine());
    int relative = Integer.parseInt(st.nextToken());
    int absolute = Integer.parseInt(st.nextToken());

    int result1 = arr.length * relative / 100;

    int result2 = 0;
    for (int i : arr) {
      if (i >= absolute) result2++;
    }

    System.out.println(result1 + " " + result2);
  }
}
