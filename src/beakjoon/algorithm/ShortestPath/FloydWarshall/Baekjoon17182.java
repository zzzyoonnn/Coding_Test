package beakjoon.algorithm.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17182 {
  static int N, K;
  static int min = 100_000;
  static boolean[] visited;
  static int[][] times;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    times = new int[N][N];
    visited = new boolean[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < N; j++) {
        times[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int k = 0; k < K; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          times[i][j] = Math.min(times[i][j], times[i][k] + times[k][j]);
        }
      }
    }

    visited[K] = true;

    System.out.print(backTracking(K, 1, 0));
  }

  private static int backTracking(int start, int depth, int time) {
    if (depth == N) {
      min = Math.min(time, min);
      return min;
    }

    for (int i = 0; i < N; i++) {
      if (i == start) continue;

      if (!visited[i]) {
        visited[i] = true;
        backTracking(i, depth + 1, time + times[start][i]);
        visited[i] = false;
      }
    }
    return -1;
  }
}
