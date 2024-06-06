package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon17829 {
  static int[][] matrix;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    matrix = new int[n][n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(recur(0, 0, n));
  }

  public static int recur(int i, int j, int size) {

    if (size == 2) {
      int[] arr = new int[4];

      int index = 0;
      for (int r = i; r < i + 2; r++) {
        for (int c = j; c < j + 2; c++) {
          arr[index++] = matrix[r][c];
        }
      }

      Arrays.sort(arr);
      return arr[2];
    } else {
      int[] arr = new int[4];
      size /= 2;

      arr[0] = recur(i, j, size);                   // Top-left quadrant
      arr[1] = recur(i, j + size, size);            // Top-right quadrant
      arr[2] = recur(i + size, j, size);            // Bottom-left quadrant
      arr[3] = recur(i + size, j + size, size);     // Bottom-right quadrant

      Arrays.sort(arr);
      return arr[2];
    }
  }
}
