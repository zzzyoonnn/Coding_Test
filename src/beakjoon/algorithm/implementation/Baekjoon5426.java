package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5426 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String s;
    StringBuilder sb;
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      sb = new StringBuilder();
      int num = (int)Math.sqrt(s.length());

      for (int k = num - 1; k >= 0; k--) {
        for (int j = 0; j < s.length(); j++) {
          if (j % num == k) {
            sb.append(s.charAt(j));
          }
        }
      }

      System.out.println(sb.toString());
    }
  }
}
