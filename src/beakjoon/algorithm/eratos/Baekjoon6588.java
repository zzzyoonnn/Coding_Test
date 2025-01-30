package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon6588 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean[] isNotPrime = new boolean[1000001];
    isNotPrime[0] = isNotPrime[1] = true;

    for (int i = 2; i * i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) {
        for (int j = i * i; j < isNotPrime.length; j += i) {
          isNotPrime[j] = true;
        }
      }
    }

    while (true) {
      int n = Integer.parseInt(br.readLine());

      if (n == 0) break;

      int left = 3;
      int right = n - 3;

      while (left <= right) {
        if (!isNotPrime[left] && !isNotPrime[right]) {
          if (left + right == n) break;
        }

        left += 2;
        right -= 2;
      }

      if (left > right) System.out.println(-1);
      else System.out.println(n + " = " + left + " + " + right);
    }
  }
}
