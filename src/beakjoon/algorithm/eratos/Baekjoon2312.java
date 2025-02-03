package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class Baekjoon2312 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Integer> primes = eratos();

    int n = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < n; tc++) {
      int num = Integer.parseInt(br.readLine());

      String result = getFactorization(num, primes);

      System.out.print(result);
    }
  }

  private static String getFactorization(int num, ArrayList<Integer> primes) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int index = 0;
    while (num > 1 && index < primes.size()) {
      if (num % primes.get(index) == 0) {
        map.put(primes.get(index), map.getOrDefault(primes.get(index), 0) + 1);
        num /= primes.get(index);
        index = 0;
      } else {
        index++;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i : map.keySet()) {
      sb.append(i).append(" ").append(map.get(i)).append("\n");
    }

    return sb.toString();
  }

  private static ArrayList<Integer> eratos() {
    boolean[] isNotPrime = new boolean[100_001];
    isNotPrime[0] = isNotPrime[1] = true;

    for (int i = 2; i * i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) {
        for (int j = i * i; j < isNotPrime.length; j += i) {
          isNotPrime[j] = true;
        }
      }
    }

    ArrayList<Integer> primes = new ArrayList<>();
    for (int i = 0; i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) primes.add(i);
    }

    return primes;
  }
}
