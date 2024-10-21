package beakjoon.algorithm.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2660 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // number of friends

    final int INF = Integer.MAX_VALUE / 2;
    int[][] relationships = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i != j) relationships[i][j] = INF;
      }
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
          if (relationships[i][k] != INF && relationships[k][j] != INF) {
            relationships[i][j] = Math.min(relationships[i][j], relationships[i][k] + relationships[k][j]);
          }
        }
      }
    }

    int[] scores = new int[n + 1];
    scores[0] = INF;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        scores[i] = Math.max(scores[i], relationships[i][j]);
      }
    }

    int min = Arrays.stream(scores).min().getAsInt();
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 1; i <= n; i++) {
      if (scores[i] == min) list.add(i);
    }

    StringBuilder sb = new StringBuilder();
    sb.append(min).append(' ').append(list.size()).append('\n');

    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i)).append(' ');
    }
    System.out.println(sb.toString());
  }
}
