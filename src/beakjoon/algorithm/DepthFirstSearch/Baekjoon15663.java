package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon15663 {
  static int n, m;
  static int[] arr, printArr;
  static boolean[] check;
  static String s;
  static StringBuilder sb = new StringBuilder();
  static ArrayList<String> list =  new ArrayList<String>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new int[n];
    check = new boolean[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    printArr = new int[m];

    backTracking(0, 0);

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  private static void backTracking(int index, int depth) {
    if (depth == m) {
      for (int i : printArr) {
        sb.append(i).append(' ');
      }
      s = sb.toString();
      if (!list.contains(s)) list.add(s);
      sb = new StringBuilder();
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (!check[i]) {
        check[i] = true;
        printArr[depth] = arr[i];
        backTracking(i, depth + 1);
        check[i] = false;
      }
    }
  }
}
