package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15664 {
  static int N, M, count;
  static int[] arr;
  static boolean[] visited;
  static ArrayList<String> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    visited = new boolean[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    count = 0;
    list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      backTracking(i, "", 0);
    }

    for (String s : list) {
      System.out.println(s);
    }
  }

  private static void backTracking(int start, String str, int count) {
    if (count == M) {
      if (!list.contains(str)) list.add(str);
      return;
    }

    for (int i = start; i < N; i++) {
      if (visited[i]) continue;

      visited[i] = true;
      backTracking(i + 1, str + arr[i] + " ", count + 1);
      visited[i] = false;
    }
  }
}
