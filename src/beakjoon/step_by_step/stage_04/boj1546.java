package beakjoon.step_by_step.stage_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1546 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    double max = -1;
    double sum = 0;
    double score;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      score = Double.parseDouble(st.nextToken());
      sum += score;
      max = Math.max(max, score);
    }

    System.out.print(sum / n / max * 100);
  }
}
