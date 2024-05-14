package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4673 {
  public static void main(String[] main) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean[] check = new boolean[10001];

    for (int i = 1; i <= 10000; i++) {
      int n = d(i);

      if (n <= 10000) {
        check[n] = true;
      }
    }

    for (int i = 1; i <= 10000; i++) {
      if (!check[i]) System.out.println(i);
    }
  }

  public static int d(int num) {
    int sum = num;

    while (num != 0) {
      sum += (num % 10);
      num /= 10;
    }

    return sum;
  }
}
