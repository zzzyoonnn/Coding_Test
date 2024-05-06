package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon26215 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // 집의 수

    int[] arr = new int[n];

    int sum = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum += arr[i];
    }

    Arrays.sort(arr);

    int max = arr[arr.length - 1];

    int count = sum / 2;
    if (sum % 2 != 0) count++;

    sum -= max;
    if (max > sum) count = max;

    if (count > 1440) System.out.println(-1);
    else System.out.println(count);
  }
}
