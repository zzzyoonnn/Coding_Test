package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3060 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      int n = Integer.parseInt(br.readLine());

      int total = 0;
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 6; i++) {
        total += Integer.parseInt(st.nextToken());
      }

      int count = 1;
      while (total <= n) {
        count++;
        total *= 4;
      }

      System.out.println(count);
    }
  }
}
