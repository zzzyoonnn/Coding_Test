package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon27159 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // 카드의 개수
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[n];
    int sum = Integer.parseInt(st.nextToken());
    arr[0] = sum;
    for (int i = 1; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (arr[i] - arr[i - 1] > 1) sum += arr[i]; 
    }

    System.out.println(sum);
  }
}
