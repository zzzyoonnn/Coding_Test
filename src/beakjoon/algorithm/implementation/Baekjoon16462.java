package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon16462 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int scoreSum = 0;

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      String scoreString = "";
      for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j);
        if (c == '0' || c == '6' || c == '9') c = '9';

        scoreString += String.valueOf(c);
      }

      int score = Integer.parseInt(scoreString);
      if (score > 100) score = 100;

      scoreSum += score;
    }

    double result = (double)scoreSum / n;
    System.out.print(String.format("%.0f", result));
  }
}
