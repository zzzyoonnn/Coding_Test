package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1051 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    char[][] arr = new char[n][m];
    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine().toCharArray();
    }

    int max = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int k = 0; k < Math.min(n - i, m - j); k++) {
          char vertex1 = arr[i][j];
          char vertex2 = arr[i][j + k];
          char vertex3 = arr[i + k][j];
          char vertex4 = arr[i + k][j + k];

          if (vertex1 == vertex2 && vertex2 == vertex3 && vertex3 == vertex4) {
            max = Math.max(max, (k + 1) * (k + 1));
          }
        }
      }
    }

    System.out.print(max);
  }
}
