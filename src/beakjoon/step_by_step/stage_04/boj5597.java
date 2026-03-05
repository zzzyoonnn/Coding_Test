package beakjoon.step_by_step.stage_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5597 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean[] check = new boolean[31];

    for (int i = 0; i < 28; i++) {
      check[Integer.parseInt(br.readLine())] = true;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < 31; i++) {
      if (!check[i]) sb.append(i).append('\n');
    }
    System.out.print(sb);
  }
}
