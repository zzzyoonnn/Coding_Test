package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2145 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int sum = 0;
    int n;
    while (true) {
      n = Integer.parseInt(br.readLine());

      if (n == 0) break;

      sum = 0;

      if (n < 10) {
        System.out.println(n);
      } else {

        while (true) {
          sum = plus(n);

          n = sum;

          if (n < 10) break;
        }
        System.out.println(n);
      }
    }
  }

  static int plus(int n) {
    int sum = 0;
    while (n != 0) {
      int temp = n % 10;
      sum += temp;
      n /= 10;
    }

    return sum;
  }
}
