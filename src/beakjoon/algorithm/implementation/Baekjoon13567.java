package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13567 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int x = 0, y = 0;
    int dir = 0;  // east = 0, north = 1, west = 2, south = 3

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      int num = Integer.parseInt(st.nextToken());

      switch (command) {
        case "TURN":
          if (num == 0) dir = (dir + 1) % 4;
          else dir = (dir + 3) % 4;
          break;
        case "MOVE":
          if (dir == 0) x += num;
          else if (dir == 1) y += num;
          else if (dir == 2) x -= num;
          else if (dir == 3) y -= num;

          if (x > m || y > m || x < 0 || y < 0) {
            System.out.println(-1);
            System.exit(0);
          }
          break;
      }
    }

    System.out.println(x + " " + y);
  }
}
