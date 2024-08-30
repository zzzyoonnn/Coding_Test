package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1331 {
  static int startC, startR, preC, preR, nowC, nowR, count = 0;
  static String pos;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static boolean[][] arr = new boolean[6][6];
  static int[] dx = {2, 2, 1, -1, -2, -2, 1, -1};
  static int[] dy = {1, -1, 2, 2, 1, -1, -2, -2};

  public static void main(String[] args) throws IOException {

    pos = br.readLine();
    preC = pos.charAt(0) - 'A';
    preR = pos.charAt(1) - '1';
    startC = preC;
    startR = preR;
    arr[preC][preR] = true;

    boolean check = false;
    for (int i = 1; i < 36; i++) {
      pos = br.readLine();
      nowC = pos.charAt(0) - 'A';
      nowR = pos.charAt(1) - '1';

      check = false;

      for (int k = 0; k < 8; k++) {
        int nx = preC + dx[k];
        int ny = preR + dy[k];

        if (nx == nowC && ny == nowR) {
          check = true;
          break;
        }
      }

      if (!check || arr[nowC][nowR]) {
        System.out.println("Invalid");
        System.exit(0);
      }

      arr[nowC][nowR] = true;

      preC = nowC;
      preR = nowR;
    }

    check = false;
    for (int k = 0; k < 8; k++) {
      int nx = preC + dx[k];
      int ny = preR + dy[k];

      if (nx == startC && ny == startR) {
        System.out.println("Valid");
        System.exit(0);
      }
    }

    System.out.println("Invalid");
  }
}