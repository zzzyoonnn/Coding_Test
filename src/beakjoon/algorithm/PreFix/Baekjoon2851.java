package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2851 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] score = new int[10];

    for (int i = 0; i < score.length; i++) {
      score[i] = Integer.parseInt(br.readLine());
    }

    int[] arr = new int[10];
    int total = 0;
    int min = Integer.MAX_VALUE;
    int result = 0;
    for (int i = 0; i < score.length; i++) {
      total += score[i];
      arr[i] = Math.abs(100 - total);
      if (min >= arr[i]) {
        result = total;
        min = arr[i];
      }
    }

    System.out.println(result);
  }
}
