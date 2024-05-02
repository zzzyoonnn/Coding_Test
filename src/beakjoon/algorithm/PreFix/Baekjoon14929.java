package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon14929 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    ArrayList<Long> list = new ArrayList<>();
    list.add(0l);
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      list.add(list.get(i - 1) + Integer.parseInt(st.nextToken()));
    }


    long sum = 0l;
    for (int i = 1; i < n; i++) {
      sum += (list.get(i) - list.get(i - 1)) * (list.get(n) - list.get(i));
    }

    System.out.println(sum);
  }
}
