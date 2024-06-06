package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon16674 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[10];

    while (n != 0) {
      arr[n % 10]++;

      n /= 10;
    }

    if (arr[3] != 0 || arr[4] != 0 || arr[5] != 0 || arr[6] != 0 || arr[7] != 0 || arr[9] != 0) {
      System.out.println(0);
      System.exit(0);
    }

    if (arr[0] > 0 && arr[1] > 0 && arr[2] > 0 && arr[8] > 0) {
      if (arr[0] == arr[1] && arr[0] == arr[2] && arr[0] == arr[8]) {
        System.out.println(8);
        System.exit(0);
      } else {
        System.out.println(2);
        System.exit(0);
      }
    } else {
      System.out.println(1);
      System.exit(0);
    }
  }
}
