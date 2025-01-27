package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon6219 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    boolean[] isNotPrime = new boolean[4_000_000 + 1];
    isNotPrime[0] = isNotPrime[1] = true;

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

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    String D = st.nextToken();

    int count = 0;
    for (int index = 0; index < primes.size(); index++) {
      if (primes.get(index) >= A && primes.get(index) <= B) {
        String num = String.valueOf(primes.get(index));

        if (num.contains(D)) count++;
      }
    }

    System.out.print(count);
  }
}
