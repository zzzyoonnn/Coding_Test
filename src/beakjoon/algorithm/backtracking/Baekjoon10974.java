package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon10974 {
  static int N;
  static int[] arr;
  static boolean[] visited;
  static StringBuilder sb;
  static ArrayList<String> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = i + 1;
    }
    visited = new boolean[N];

    sb = new StringBuilder();
    list = new ArrayList<>();
    backTrack(0);

    Collections.sort(list);

    for (String s : list) {
      System.out.println(s);
    }
  }

  private static void backTrack(int count) {
    if (count == N) {
      list.add(sb.toString().trim());
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i]) continue;

      visited[i] = true;
      sb.append(arr[i]).append(' ');
      backTrack(count + 1);
      sb.setLength(sb.length() - 2);
      visited[i] = false;
    }
  }
//
//  private static int factorial(int n) {
//    if (n == 1) return 1;
//    return n * factorial(n - 1);
//  }
}
