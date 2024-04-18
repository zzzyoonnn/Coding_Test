package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon21966 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 문자열의 길이
    String s = br.readLine();
    StringBuilder sb = new StringBuilder();

    // 규칙 1.
    if (n <= 25) {
      sb.append(s);
    } else {
      String mid = s.substring(12, s.length() - 12);

      boolean check = true;
      if (mid.contains(".")) check = false;

      if (check) {
        // 규칙 2.
        sb.append(s.substring(0, 11)).append("...").append(s.substring(s.length() - 11));
      } else {
        // 규칙 3.
        sb.append(s.substring(0, 9)).append("......").append(s.substring(s.length() - 10));
      }
    }

    System.out.println(sb);
  }
}
