package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon18110 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    double doubleN = n * 0.15;
    int standard = (int)Math.round(doubleN);

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    int sum = 0;
    int index = 0;
    for (int i = standard; i < arr.length - standard; i++) {
      sum += arr[i];
      index++;
    }

    double result = sum / (double)index;

    System.out.print(Math.round(result));
  }
}
