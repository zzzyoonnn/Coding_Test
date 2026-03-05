package beakjoon.step_by_step.stage_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj3052 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> list = new ArrayList<>();

    int n, m;
    for (int i = 0; i < 10; i++) {
      n = Integer.parseInt(br.readLine());
      m = n % 42;

      if (!list.contains(m)) list.add(m);
    }

    System.out.print(list.size());
  }
}
