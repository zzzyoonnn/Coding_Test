package beakjoon.step_by_step.stage_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2884 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    if (h == 0) h = 24;

    int time = (h * 60) + m - 45;

    int H = time / 60;
    if (H == 24) H = 0;

    int M = time % 60;

    System.out.print(H + " " + M);
  }
}
