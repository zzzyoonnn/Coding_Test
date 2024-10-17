package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Baekjoon1058 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[][] arr = new char[n][n];

    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine().toCharArray();
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i == j || i == k || j == k) continue;
          if (arr[i][j] == 'N' && arr[i][k] == 'Y' && arr[k][j] == 'Y') {
            arr[i][j] = 'N';
          }
        }
      }
    }

    int[] count = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) continue;
        if (arr[i][j] == 'Y') count[i]++;
        if (arr[j][i] == 'Y') count[j]++;
      }
    }

    int max = Arrays.stream(count).max().getAsInt();

    System.out.println(max);
  }
}
