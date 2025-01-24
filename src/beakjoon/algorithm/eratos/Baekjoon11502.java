package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11502 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    boolean[] check = new boolean[1001];
    check[0] = check[1] = true;

    for (int index = 2; index * index < check.length; index++) {
      if (!check[index]) {
        for (int i = index * index; i < check.length; i += index) {
          check[i] = true;
        }
      }
    }

    for (int tc = 0; tc < T; tc++) {
      int n = Integer.parseInt(br.readLine());

      for (int i = 2; i <= n; i++) {
        if (check[i]) continue;

        for (int j = 2; j <= n; j++) {
          if (check[j]) continue;

          for (int k = 2; k <= n; k++) {
            if (check[k]) continue;

            if (i + j + k == n) {
              System.out.println(i + " " + j + " " + k);
              break;
            }
          }
        }
      }
    }
  }
}
