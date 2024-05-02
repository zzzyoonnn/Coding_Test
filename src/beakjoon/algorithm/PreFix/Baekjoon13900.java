package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon13900 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 입력 받을 정수의 개수

    StringTokenizer st = new StringTokenizer(br.readLine());
    ArrayList<Long> list = new ArrayList<>();
    list.add(0l);

    for (int i = 1; i <= n; i++) {
      list.add(list.get(i - 1) + Integer.parseInt(st.nextToken()));
    }

    long sum = 0;
    long last = list.get(list.size() - 1);
    for (int i = 1; i < n; i++) {
      sum += (list.get(i) - list.get(i - 1)) * (last - list.get(i));
    }

    System.out.println(sum);
  }
}
