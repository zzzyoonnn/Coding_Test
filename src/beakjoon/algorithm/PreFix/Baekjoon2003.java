package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2003 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 수열의 크기
    int m = Integer.parseInt(st.nextToken());       // 찾고 싶은 누적 합 수

    ArrayList<Integer> list = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    list.add(0);
    for (int i = 1; i <= n; i++) {
      list.add(list.get(i - 1) + Integer.parseInt(st.nextToken()));
    }

    int count = 0;
    for (int i = 0; i <= n; i++) {
      for (int j = i; j <= n; j++) {
        if ((list.get(j) - list.get(i)) == m) count++;
      }
    }

    System.out.println(count);
  }
}
