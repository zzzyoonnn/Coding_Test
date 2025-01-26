package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon15965 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean[] isNotPrime = new boolean[10000000];
    isNotPrime[0] = isNotPrime[1] = true;

    int n = Integer.parseInt(br.readLine());
    for (int i = 2; i * i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) {
        for (int j = i * i; j < isNotPrime.length; j += i) {
          isNotPrime[j] = true;
        }
      }
    }

    ArrayList<Integer> primes = new ArrayList<>();
    for (int i = 2; i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) primes.add(i);
    }

    System.out.print(primes.get(n - 1));
  }
}
