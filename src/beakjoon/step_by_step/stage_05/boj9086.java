package beakjoon.step_by_step.stage_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9086 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    String s;
    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < t; tc++) {
      s = br.readLine();

      sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append('\n');
    }
    System.out.print(sb);
  }
}
