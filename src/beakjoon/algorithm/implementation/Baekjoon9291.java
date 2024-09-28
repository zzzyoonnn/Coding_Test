package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon9291 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    String[][] arr;
    boolean check;
    HashSet<String> set;
    StringBuilder sb = new StringBuilder();

    for (int tc = 1; tc <= t; tc++) {
      sb.append("Case ").append(tc);

      check = true;
      arr = new String[9][9];

      for (int i = 0; i < 9; i++) {
        arr[i] = br.readLine().split(" ");
      }

      if (tc != t) br.readLine();

      // Row
      for (int i = 0; i < 9; i++) {
        set = new HashSet<>();

        for (int j = 0; j < 9; j++) {
          set.add(arr[i][j]);
        }

        if (set.size() != 9) {
          check = false;
          break;
        }
      }

      // Column
      if (check) {
        for (int i = 0; i < 9; i++) {
          set = new HashSet<>();

          for (int j = 0; j < 9; j++) {
            set.add(arr[j][i]);
          }

          if (set.size() != 9) {
            check = false;
            break;
          }
        }
      }

      // 3 x 3
      if (check) {
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            set = new HashSet<>();

            set.add(arr[i * 3][3 * j]);
            set.add(arr[i * 3][3 * j + 1]);
            set.add(arr[i * 3][3 * j + 2]);

            set.add(arr[i * 3 + 1][3 * j]);
            set.add(arr[i * 3 + 1][3 * j + 1]);
            set.add(arr[i * 3 + 1][3 * j + 2]);

            set.add(arr[i * 3 + 2][3 * j]);
            set.add(arr[i * 3 + 2][3 * j + 1]);
            set.add(arr[i * 3 + 2][3 * j + 2]);

            if (set.size() != 9) {
              check = false;
              break;
            }
          }
        }
      }

      if (check) sb.append(": CORRECT").append('\n');
      else sb.append(": INCORRECT").append('\n');
    }
    System.out.print(sb);
  }
}
