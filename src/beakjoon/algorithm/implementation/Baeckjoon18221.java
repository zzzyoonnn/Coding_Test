package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baeckjoon18221 {
  static int n;
  static String[][] arr;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());

    arr = new String[n][n];
    visited = new boolean[n][n];

    int pX = 0, pY = 0;   // professor's position
    int sX = 0, sY = 0;   // sungyu's position
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = st.nextToken();

        if (arr[i][j].equals("5")) {
          pX = i;
          pY = j;
        } else if (arr[i][j].equals("2")) {
          sX = i;
          sY = j;
        }
      }
    }

    int x = Math.abs(pX - sX);
    int y = Math.abs(pY - sY);

    if ((x * x) + (y * y) < 25) {
      System.out.println(0);
      System.exit(0);
    }

    int count = 0;
    for (int i = Math.min(pX, sX); i <= Math.max(pX, sX); i++) {
      for (int j = Math.min(pY, sY); j <= Math.max(pY, sY); j++) {
        if (arr[i][j].equals("1")) {
          count++;
        }
      }
    }

    if (count < 3) {
      System.out.println(0);
      System.exit(0);
    }

    System.out.println(1);
  }
}
