package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon17249 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringBuilder sb = new StringBuilder();

    int left = 0;
    int right = 0;
    int index = 0;
    while (s.charAt(index) != '(') {
      if (s.charAt(index) == '@') left++;
      index++;
    }

    sb.append(left).append(' ');

    while (index < s.length()) {
      if (s.charAt(index) == '@') right++;
      index++;
    }

    sb.append(right);

    System.out.print(sb.toString());
  }
}
