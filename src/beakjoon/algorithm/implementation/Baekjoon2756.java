package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2756 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    int n = 0;
    int m = 0;
    double score = 0;
    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < 3; i++) {
        score = Double.parseDouble(st.nextToken());

        if (score < 0) score *= -1;

        if (score <= 3) n += 100;
        else if (score <= 6) n += 80;
        else if (score <= 9) n += 60;
        else if (score <= 12) n += 40;
        else if (score <= 15) n += 20;
      }

      for (int i = 0; i < 3; i++) {
        score = Double.parseDouble(st.nextToken());

        if (score < 0) score *= -1;

        if (score <= 3) m += 100;
        else if (score <= 6) m += 80;
        else if (score <= 9) m += 60;
        else if (score <= 12) m += 40;
        else if (score <= 15) m += 20;
      }

      System.out.println(n + " " + m);
    }
  }
}
