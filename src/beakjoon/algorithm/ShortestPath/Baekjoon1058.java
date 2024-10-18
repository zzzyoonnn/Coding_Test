package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1058 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    final int INF = Integer.MAX_VALUE;
    int[][] friends = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        friends[i][j] = INF;
      }
    }

    String s;
    for (int i = 0; i < n; i++) {
      s = br.readLine();
      for (int j = 0; j < n; j++) {
        if (s.charAt(j) == 'Y') {
          friends[i][j] = 1;
          friends[j][j] = 1;
        }
      }
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i != j && i != k && j != k) continue;
          if (friends[i][k] != INF && friends[k][j] != INF) {
            friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
          }
        }
      }
    }

    int[] count = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j) continue;
        if (friends[i][j] == 1 ||friends[i][j] == 2) count[i]++;
      }
    }

    int max = Arrays.stream(count).max().getAsInt();

    System.out.println(max);
  }
}
