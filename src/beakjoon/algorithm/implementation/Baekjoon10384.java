package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10384 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s;
    int[] arr;

    for (int i = 1; i <= n; i++) {
      s = br.readLine().toLowerCase();
      arr = new int[26];

      for (int j = 0; j < s.length(); j++) {
        int num = s.charAt(j) - 'a';

        if (num >= 0 && num < 26) arr[num]++;
      }

      int min = Arrays.stream(arr).min().getAsInt();

      switch(min) {
        case 0:
          System.out.println("Case " + i + ": Not a pangram");
          break;
        case 1:
          System.out.println("Case " + i + ": Pangram!");
          break;
        case 2:
          System.out.println("Case " + i + ": Double pangram!!");
          break;
        case 3:
          System.out.println("Case " + i + ": Triple pangram!!!");
          break;
      }
    }
  }
}
