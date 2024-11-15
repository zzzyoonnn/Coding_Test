package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon16922 {
  private static int n;
  private static int[] roma = {1, 5, 10, 50};
  private static HashSet<Integer> set = new HashSet<Integer>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    dfs(0, 0, 0);

    System.out.println(set.size());
  }

  private static void dfs(int now, int depth, int start) {
    if (depth == n) {
      set.add(now);
      return;
    }

    for (int k = start; k < roma.length; k++) {
      dfs(now + roma[k], depth + 1, k);
    }
  }
}
