package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon31821 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 메뉴의 개수
    int[] arr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int sum = 0;
    int m = Integer.parseInt(br.readLine());        // 새내기의 인원 수
    for (int i = 0; i < m; i++) {
      sum += arr[Integer.parseInt(br.readLine())];
    }

    System.out.println(sum);
  }
}
