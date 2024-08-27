package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon2774 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    HashSet<Integer> set;

    for (int tc = 0; tc < t; tc++) {
      int x = Integer.parseInt(br.readLine());
      set = new HashSet<>();

      while (x != 0) {
        int n = x % 10;
        set.add(n);

        x /= 10;
      }

      System.out.println(set.size());
    }
  }
}
