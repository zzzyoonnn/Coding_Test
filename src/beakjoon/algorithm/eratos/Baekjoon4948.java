package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4948 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean[] check = new boolean[(123456 * 2) + 1];
    check[0] = check[1] = true;

    for (int index = 2; index * index < check.length; index++) {
      if (!check[index]) {
        for (int i = index * index; i < check.length; i += index) {
          check[i] = true;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    int n, count;

    while (true) {
      n = Integer.parseInt(br.readLine());

      if (n == 0) break;

      count = 0;

      for (int i = n + 1; i <= 2 * n; i++) {
        if (!check[i]) count++;
      }

      sb.append(count).append("\n");
    }

    System.out.println(sb.toString());
  }
}
