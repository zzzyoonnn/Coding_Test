package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon22935 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb;
    for (int tc = 0; tc < t; tc++) {
      sb = new StringBuilder();
      int num = Integer.parseInt(br.readLine()) - 1;
      num %= 28;
      num++;

      if (num >= 15) {
        num = 30 - num;
      }

      String binary = String.format("%4s", Integer.toString(num, 2)).replace(' ', '0');

      for (int i = 0; i < 4; i++) {
        char c = binary.charAt(i);

        if (c == '0') sb.append('V');
        else sb.append("딸기");
      }
      System.out.println(sb);
    }
  }
}
