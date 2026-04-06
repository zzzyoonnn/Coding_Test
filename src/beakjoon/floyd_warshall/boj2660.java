package beakjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj2660 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] relationships = new int[n + 1][n + 1];
    int INF = 50;

    for (int i = 0; i <= n; i++) {
      Arrays.fill(relationships[i], INF);
    }

    StringTokenizer st;
    while (true) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (a == -1 && b == -1) break;

      relationships[a][b] = 1;
      relationships[b][a] = 1;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (relationships[i][k] != INF && relationships[j][k] != INF) {
            relationships[i][j] = Math.min(relationships[i][j], relationships[i][k] + relationships[j][k]);
          }
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      relationships[i][i] = 0;
    }

    ArrayList<Integer> result = new ArrayList<>();

    int[] scores = new int[n + 1];
    Arrays.fill(scores, -1);
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) continue;
        if (scores[i] < relationships[i][j]) {
          scores[i] = relationships[i][j];
        }
      }
    }

    int score = INF;
    for (int i = 1; i <= n; i++) {
      score = Math.min(score, scores[i]);
    }

    for (int i = 1; i <= n; i++) {
      if (score == scores[i]) result.add(i);
    }

    Collections.sort(result);
    StringBuilder sb = new StringBuilder();
    sb.append(score).append(' ').append(result.size()).append('\n');
    for (int i : result) sb.append(i).append(' ');

    System.out.print(sb);
  }
}
