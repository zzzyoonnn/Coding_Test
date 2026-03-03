package beakjoon.step_by_step.stage_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2525 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(br.readLine());

    int time = (a * 60) + b + c;

    int H = time / 60;
    if (H >= 24) H -= 24;

    int M = time % 60;

    System.out.print(H + " " + M);
  }
}
