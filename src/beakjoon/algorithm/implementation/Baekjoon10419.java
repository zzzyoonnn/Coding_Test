package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10419 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());    // 궁금한 경우의 수

    for (int i = 0; i < t; i++) {
      int time = Integer.parseInt(br.readLine());

      int sum = 0;
      for (int j = 1; j <= time; j++) {
        sum = j + (j * j);

        if (sum > time) {
          System.out.println(j - 1);
          break;
        }
      }
    }
  }
}
