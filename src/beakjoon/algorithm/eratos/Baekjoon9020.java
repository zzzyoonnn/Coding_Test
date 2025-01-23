package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9020 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean[] check = new boolean[10001];
    check[0] = check[1] = true;

    for (int index = 2; index * index < check.length; index++) {
      if (!check[index]) {
        for (int i = index * index; i < check.length; i += index) {
          check[i] = true;
        }
      }
    }

    int t = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < t; tc++) {
      int n = Integer.parseInt(br.readLine());
      int a = 10000;
      int b = -10000;

      for (int i = 2; i < check.length; i++) {
        if (!check[i]) {
          for (int j = 2; j < check.length; j++) {
            if (!check[j]) {
              if (i + j == n) {
                if (a - b > i - j) {
                  a = i;
                  b = j;
                }
              }
            }
          }
        }
        System.out.println(a + " " + b);
      }
    }
  }
}
