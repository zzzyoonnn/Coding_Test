package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12778 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());        // 시험문제의 개수

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < t; tc++) {
      st = new StringTokenizer(br.readLine());

      int m = Integer.parseInt(st.nextToken());     // 알파벳 또는 숫자의 개수
      String type = st.nextToken();                 // 문제의 종류

      st = new StringTokenizer(br.readLine());
      if (type.equals("C")) {
        for (int i = 0; i < m; i++) {
          String s = st.nextToken();
          char c = s.charAt(0);
          sb.append(c - 'A' + 1).append(' ');
        }
      } else if (type.equals("N")) {
        for (int i = 0; i < m; i++) {
          int index = Integer.parseInt(st.nextToken());
          sb.append((char)(index + 'A' - 1)).append(' ');
        }
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
}
