package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2559 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 온도를 측정한 전체 날짜의 수
    int k = Integer.parseInt(st.nextToken());       // 연속적인 날짜의 수

    ArrayList<Integer> list = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    list.add(0);
    for (int i = 1; i <= n; i++) {
      list.add(list.get(i - 1) + Integer.parseInt(st.nextToken()));
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i <= n - k; i++) {
      System.out.println(list.get(i + k) - list.get(i));
      max = Math.max(max, list.get(i + k) - list.get(i));
    }

    System.out.println(max);
  }
}