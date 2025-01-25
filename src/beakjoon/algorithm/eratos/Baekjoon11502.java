package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon11502 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    boolean[] isNotPrime = new boolean[1001];
    isNotPrime[0] = isNotPrime[1] = true;

    for (int index = 2; index * index < isNotPrime.length; index++) {
      if (!isNotPrime[index]) {
        for (int i = index * index; i < isNotPrime.length; i += index) {
          isNotPrime[i] = true;
        }
      }
    }

    ArrayList<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= 1000; i++) {
      if (!isNotPrime[i]) {
        primes.add(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < T; tc++) {
      int n = Integer.parseInt(br.readLine());
      boolean check = false;

      for (int i = 2; i <= n; i++) {
        if (check) break;
        for (int j = i; j <= n; j++) {
          for (int k = j; k <= n; k++) {
            if (!isNotPrime[i] && !isNotPrime[j] && !isNotPrime[k]) {
              if (i + j + k == n) {
                sb.append(i).append(" ").append(j).append(" ").append(k).append("\n");
                check = true;
              }
            }
          }
          if (check) break;
        }
        if (check) break;
      }
      if (!check) sb.append(0).append("\n");
    }

    System.out.print(sb.toString());
  }
}
