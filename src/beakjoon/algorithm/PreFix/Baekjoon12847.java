package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon12847 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 월세를 내기 바로 전 날
    int m = Integer.parseInt(st.nextToken());       // 일을 할 수 있는 날

    ArrayList<Integer> list = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    long sum = 0;
    for (int i = 0; i < m; i++) {
      sum += list.get(i);
    }
    long max = sum;

    for (int i = 0; i < n - m; i++) {
      sum += list.get(i + m) - list.get(i - 0);
      max = Math.max(sum, max);
    }

    System.out.println(max);
  }
}
