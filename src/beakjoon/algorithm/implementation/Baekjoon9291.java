package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9291 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    String s;
    boolean[] check;
    String[][] arr;
    boolean result;

    for (int tc = 1; tc <= t; tc++) {
      result = false;
      check = new boolean[10];
      arr = new String[9][9];

      for (int i = 0; i < 9; i++) {
        arr[i] = br.readLine().split(" ");
      }
      if (tc != t) br.readLine();

      // Row
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          check[Integer.parseInt(arr[i][j])] = true;
        }

        for (int j = 1; j <= 9; j++) {
          if (check[j]) result = true;
        }
      }

      // Column
      if (result) {
        check = new boolean[10];
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            check[Integer.parseInt(arr[j][i])] = true;
          }

          for (int j = 1; j <= 9; j++) {
            if (check[j]) result = true;
          }
        }
      }

      // 3 x 3
      if (result) {
        check = new boolean[10];
        for (int roop = 0; roop < 3; roop++) {
          check = new boolean[10];
          for (int i = roop * 3; i < 3; i++) {
            for (int j = roop * 3; j < 3; j++) {
              check[Integer.parseInt(arr[i][j])] = true;
            }
          }

          for (int j = 1; j <= 9; j++) {
            if (check[j]) result = true;
          }
        }
      }

      if (result) System.out.println("Case " + tc + ": CORRECT");
      else System.out.println("Case " + tc + ": INCORRECT");
    }
  }
}
