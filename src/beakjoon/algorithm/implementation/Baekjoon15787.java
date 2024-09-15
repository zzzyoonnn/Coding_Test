package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon15787 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of train
    int m = Integer.parseInt(st.nextToken());   // number of command

    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = "00000000000000000000";
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int command = Integer.parseInt(st.nextToken());

      switch(command) {
        case 1:
          int index = Integer.parseInt(st.nextToken());
          int seat = Integer.parseInt(st.nextToken());

          if (arr[index].charAt(seat) == '0') break;

          arr[index] = arr[index].substring(0, seat - 1) + '1' + arr[index].substring(seat + 1);
          System.out.println(arr[index]);
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
      }
    }
  }
}
