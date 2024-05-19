package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10174 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    String s;
    for (int tc = 0; tc < t; tc++) {
      boolean check = true;
      s = br.readLine();
      for (int i = 0; i < s.length() / 2; i++) {
        char left = s.charAt(i);
        char right = s.charAt(s.length() - i - 1);

        if (left >= 'A' && left <= 'Z') left = (char)(left - 'A' + 'a');
        if (right >= 'A' && right <= 'Z') right = (char)(right - 'A' + 'a');

        if (left != right) check = false;
      }
      if (check) System.out.println("Yes");
      else System.out.println("No");
    }
  }
}
