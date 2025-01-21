package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon24039 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    boolean[] check = new boolean[10_000 * 10_000];
    check[0] = check[1] = true;

    for (int index = 2; index * index < check.length; index++) {
      if (!check[index]) {
        for (int i = index * index; i < check.length; i += index) {
          check[i] = true;
        }
      }
    }

    int pre = 2;
    int result = -1;
    for (int i = 3; i < check.length; i++) {
      if (!check[i]) {
        result = pre * i;
        if (result > n) break;

        pre = i;
      }
    }

    System.out.print(result);
  }
}
