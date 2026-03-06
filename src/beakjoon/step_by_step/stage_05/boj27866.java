package beakjoon.step_by_step.stage_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj27866 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int i = Integer.parseInt(br.readLine());
    System.out.print(s.charAt(i - 1));
  }
}
