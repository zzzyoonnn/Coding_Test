package beakjoon.step_by_step.stage_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2562 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n;
    int max = -1;
    int index = -1;

    for (int i = 1; i <= 9; i++) {
      n = Integer.parseInt(br.readLine());

      if (n > max) {
        max = n;
        index = i;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(max).append('\n').append(index);
    System.out.print(sb);
  }
}
