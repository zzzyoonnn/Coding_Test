package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10205 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    for (int i = 1; i <= k; i++) {
      int h = Integer.parseInt(br.readLine());
      String s = br.readLine();
      for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j);
        if (c == 'b') h--;
        else if (c == 'c') h++;

        if (h == 0) break;
      }

      System.out.println("Data Set " + i + ":");
      System.out.println(h);
      System.out.println();
    }
  }
}
