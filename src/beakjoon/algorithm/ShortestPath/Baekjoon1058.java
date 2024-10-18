package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1058 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String s;
    final int INF = Integer.MAX_VALUE;
    int[][] friends = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        friends[i][j] = INF;
      }
    }

    for (int i = 0; i < n; i++) {
      s = br.readLine();
      for (int j = 0; j < n; j++) {
        if (s.charAt(j) == 'Y') {
          friends[i][j] = 1;
          friends[j][i] = 1;
        }
      }
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i != j && friends[i][k] != INF && friends[k][j] != INF) {
            friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
          }
        }
      }
    }

    int count, max = 0;
    for (int i = 0; i < n; i++) {
      count = 0;
      for (int j = 0; j < n; j++) {
        if (i == j) continue;
        if (friends[i][j] == 1 ||friends[i][j] == 2) count++;
      }
      max = Math.max(max, count);
    }
    System.out.print(max);
  }
}
