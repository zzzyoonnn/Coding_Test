package beakjoon.step_by_step.stage_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2588 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int i1 = Integer.parseInt(br.readLine());
    int i2 = Integer.parseInt(br.readLine());

    System.out.println(i1 * (i2 % 10));
    System.out.println(i1 * ((i2 % 100) / 10));
    System.out.println(i1 * (i2 / 100));
    System.out.print(i1 * i2);
  }
}
