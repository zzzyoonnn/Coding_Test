package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon15787 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of trains
    int m = Integer.parseInt(st.nextToken());   // number of commands

    int[][] arr = new int[n + 1][21];

    int index, seat;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int command = Integer.parseInt(st.nextToken());

      switch(command) {
        case 1:
          index = Integer.parseInt(st.nextToken());
          seat = Integer.parseInt(st.nextToken());

          if (arr[index][seat] == 0) arr[index][seat] = 1;

          break;
        case 2:
          index = Integer.parseInt(st.nextToken());
          seat = Integer.parseInt(st.nextToken());

          if (arr[index][seat] == 1) arr[index][seat] = 0;

          break;
        case 3:
          index = Integer.parseInt(st.nextToken());

          for (int tmp = 20; tmp >= 1; tmp--) {
            arr[index][tmp] = arr[index][tmp - 1];
          }
          break;
        case 4:
          index = Integer.parseInt(st.nextToken());

          for (int tmp = 2; tmp <= 20; tmp++) {
            arr[index][tmp - 1] = arr[index][tmp];
          }
          arr[index][20] = 0;
          break;

      }
    }

    int count = 0;
    HashSet<String> set = new HashSet<String>();
    StringBuilder sb;
    for (int i = 1; i < n + 1; i++) {
      sb = new StringBuilder();
      for (int j = 1; j <= 20; j++) {
        sb.append(Integer.toString(arr[i][j]));
      }
      System.out.println(sb.toString());
      set.add(sb.toString());
    }

    System.out.println(set.size());
  }
}
