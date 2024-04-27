package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon11441 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());            // 수의 개수

    StringTokenizer st = new StringTokenizer(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    list.add(0);
    for (int i = 1; i <= n; i++) {
      list.add(list.get(i - 1) + Integer.parseInt(st.nextToken()));
    }

    int m = Integer.parseInt(br.readLine());            // 수의 개수
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      System.out.println(list.get(end) - list.get(start - 1));
    }
  }
}
