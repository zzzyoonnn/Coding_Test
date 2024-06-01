package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4435 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());        // 전투의 개수

    int[] g = {1, 2, 3, 3, 4, 10};
    int[] s = {1, 2, 2, 2, 3, 5, 10};

    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      sb.append("Battle ").append(tc + 1).append(": ");
      st = new StringTokenizer(br.readLine());

      int gScore = 0;
      for (int i = 0; i < g.length; i++) {
        int num = Integer.parseInt(st.nextToken());

        gScore += num * g[i];
      }

      st = new StringTokenizer(br.readLine());

      int sScore = 0;
      for (int i = 0; i < s.length; i++) {
        int num = Integer.parseInt(st.nextToken());

        sScore += num * s[i];
      }

      if (gScore > sScore) sb.append("Good triumphs over Evil");
      else if (gScore == sScore) sb.append("No victor on this battle field");
      else sb.append("Evil eradicates all trace of Good");

      sb.append('\n');
    }

    System.out.println(sb);
  }
}
