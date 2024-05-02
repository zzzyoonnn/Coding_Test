package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon17390 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 수열의 길이
    int q = Integer.parseInt(st.nextToken());       // 질문의 개수

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    ArrayList<Integer> list = new ArrayList<>();
    list.add(0);
    for (int i = 1; i <= n; i++) {
      list.add(list.get(i - 1) + arr[i - 1]);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());

      sb.append(list.get(r) - list.get(l - 1)).append('\n');
    }

    System.out.println(sb);
  }
}
