package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13163 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      boolean check = false;
      while (st.hasMoreTokens()) {
        if (!check) {
          st.nextToken();
          sb.append("god");
        }
        else sb.append(st.nextToken());
        check = true;
      }

      sb.append('\n');
    }

    System.out.println(sb);
  }
}
