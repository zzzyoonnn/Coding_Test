package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon14594 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // the number of rooms
    int m = Integer.parseInt(br.readLine());    // the number of acts

    if (m == 0) {
      System.out.print(n);
      System.exit(0);
    }

    int[][] actions = new int[m][2];

    StringTokenizer st;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      actions[i][0] = Integer.parseInt(st.nextToken());   // start
      actions[i][1] = Integer.parseInt(st.nextToken());   // end
    }

    Arrays.sort(actions, (x, y) -> x[0] - y[0]);

    int count = 1;
    int preX = actions[0][0];
    int preY = actions[0][1];

    count += preX - 1;

    for (int[] action : actions) {
      int curX = action[0];
      int curY = action[1];

      if (curX >= preX && curX <= preY) {
        preX = Math.min(preX, curX);
        preY = Math.max(preY, curY);
      } else {
        count += curX - preY;

        preX = curX;
        preY = curY;
      }
    }

    if (preY != n) count += (n - preY);

    System.out.println(count);
  }
}
