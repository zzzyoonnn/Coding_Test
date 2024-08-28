package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1331 {
  static int startC, startR, preC, preR, nowC, nowR, count = 1;
  static String pos;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static boolean[][] arr = new boolean[6][6];
  static int[] dx = {2, 2, 1, -1, -2, -2, 1, -1};
  static int[] dy = {1, -1, 2, 2, 1, -1, -2, -2};

  public static void main(String[] args) throws IOException {
    boolean check = true;
    pos = br.readLine();
    preC = pos.charAt(0) - 'A';
    preR = pos.charAt(1) - '1';
    startC = preC;
    startR = preR;

    dfs(preC, preR);


    if (count == 35) System.out.println("Valid");
    else System.out.println("Invalid");
  }

  private static void dfs(int preC, int preR) throws IOException {
    arr[preC][preR] = true;
    pos = br.readLine();
    nowC = pos.charAt(0) - 'A';
    nowR = pos.charAt(1) - '1';

    for (int k = 0; k < 8; k++) {
      int nx = preC + dx[k];
      int ny = preR + dy[k];

      if (nx == nowC && ny == nowR) {
        System.out.println((char)(nx + 'A') + "" + (char)(ny + '1'));
        count++;
        if (count == 36) {
          dfs(nx, ny);

        }
        if (!arr[nx][ny]) {
          preC = nx;
          preR = ny;
          dfs(preC, preR);
        } else {
          return;
        }
      }
    }

  }
}
