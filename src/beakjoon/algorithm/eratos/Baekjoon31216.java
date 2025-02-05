package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon31216 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean[] isNotPrime = eratos();
    ArrayList<Integer> primes = primes(isNotPrime);

    int T = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < T; tc++) {
      int n = Integer.parseInt(br.readLine());

      System.out.println(primes.get(n - 1));
    }
  }

  private static ArrayList<Integer> primes(boolean[] isNotPrime) {
    ArrayList<Integer> primes = new ArrayList<>();

    int index = 0;
    for (int i = 2; i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) {
        index += 1;

        if (!isNotPrime[index]) {
          primes.add(i);
        }
      }
    }

    return primes;
  }

  private static boolean[] eratos() {
    boolean[] isNotPrime = new boolean[50_000_000];
    isNotPrime[0] = isNotPrime[1] = true;

    for (int i = 2; i * i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) {
        for (int j = i * i; j < isNotPrime.length; j += i) {
          isNotPrime[j] = true;
        }
      }
    }
    return isNotPrime;
  }
}
