package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon11659 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 수의 개수
    int m = Integer.parseInt(st.nextToken());       // 합을 구해야 하는 횟수

    st = new StringTokenizer(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    list.add(0);
    for (int i = 1; i <= n; i++) {
      list.add(list.get(i - 1) + Integer.parseInt(st.nextToken()));
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      sb.append(list.get(end) - list.get(start - 1)).append('\n');
    }
    System.out.println(sb);
  }
}
