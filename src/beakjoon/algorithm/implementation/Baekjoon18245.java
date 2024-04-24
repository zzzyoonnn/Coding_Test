package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon18245 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    String result = "";
    int blank = 1;

    while (true) {
      s = br.readLine();

      if (s.equals("Was it a cat I saw?")) break;

      result += s.charAt(0);
      int check = 0;
      for (int i = 1; i < s.length(); i++) {
        if (check == blank) {
          result += s.charAt(i);
          check = 0;
        } else {
          check++;
        }

      }
      System.out.println(result);
      result = "";
      blank++;
    }
  }
}
