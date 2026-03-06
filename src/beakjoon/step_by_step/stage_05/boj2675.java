package beakjoon.step_by_step.stage_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2675 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    int r;
    String s;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < t; tc++) {
      st = new StringTokenizer(br.readLine());

      r = Integer.parseInt(st.nextToken());
      s = st.nextToken();

      for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < r; j++) {
          sb.append(s.charAt(i));
        }
      }
      sb.append('\n');
    }

    System.out.print(sb);
  }
}
