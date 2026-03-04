package beakjoon.step_by_step.stage_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10951 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String s;

    StringBuilder sb = new StringBuilder();
    while ((s = br.readLine()) != null && !s.isEmpty()) {
      st = new StringTokenizer(s);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      sb.append(a + b).append("\n");
    }

    System.out.print(sb);
  }
}
