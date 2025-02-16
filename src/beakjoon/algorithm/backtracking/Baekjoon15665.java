package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon15665 {
  static int N, M;
  static int[] arr, printArr;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    printArr = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    sb = new StringBuilder();
    dfs(0);

    System.out.print(sb.toString());
  }

  private static void dfs(int count) {
    if (count == M) {
      for (int i = 0; i < M; i++) {
        sb.append(printArr[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    int before = -1;
    for(int i=0; i<N; i++) {
      int now = arr[i];
      if(before != now) {
        before = now;
        printArr[count] = arr[i];
        dfs(count + 1);
      }
    }
  }
}
