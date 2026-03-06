package beakjoon.step_by_step.stage_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj10809 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int[] result = new int[26];
    Arrays.fill(result, -1);

    char c;
    int index;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      index = c - 'a';

      if (result[index] == -1) result[index] = i;
    }

    StringBuilder sb = new StringBuilder();
    for (int i : result) sb.append(i).append(' ');
    System.out.print(sb);
  }
}
