package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1182 {
  static int N, S, count;
  static int[] nums;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    nums = new int[N];
    visited = new boolean[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    count = 0;
    backTracking(0, 0);

    if (S == 0) count--;

    System.out.print(count);

  }

  private static void backTracking(int index, int sum) {

    if (sum == S) {
      count += 1;
    }

    for (int i = index; i < N; i++) {

      if (!visited[i]) {
        visited[i] = true;
        backTracking(i, sum + nums[i]);
        visited[i] = false;
      }
    }
  }
}
