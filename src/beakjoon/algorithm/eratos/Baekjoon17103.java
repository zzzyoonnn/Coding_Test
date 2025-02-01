package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17103 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean[] isNotPrime = new boolean[1_000_001];
    isNotPrime[0] = isNotPrime[1] = true;

    for (int i = 2; i * i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) {
        for (int j = i * i; j < isNotPrime.length; j += i) {
          isNotPrime[j] = true;
        }
      }
    }

    int T = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < T; tc++) {
      int N = Integer.parseInt(br.readLine());

      int count = 0;
      for (int i = 1; i <= N / 2; i++) {
        if (!isNotPrime[i] && !isNotPrime[N - i]) {
          count++;
        }
      }

      System.out.println(count);
    }
  }
}
