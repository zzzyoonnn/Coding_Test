package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15784 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());   // arr's size
    int a = Integer.parseInt(st.nextToken()) - 1;   // row
    int b = Integer.parseInt(st.nextToken()) - 1;   // column

    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int standard = arr[a][b];

    boolean check = true;

    for (int c = 0; c < n; c++) {
      if (arr[a][c] > standard) check = false;
      if (arr[c][b] > standard) check = false;
    }

    if (check) System.out.print("HAPPY");
    else System.out.print("ANGRY");
  }
}
