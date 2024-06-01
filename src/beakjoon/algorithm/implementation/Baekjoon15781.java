package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15781 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());       // 헬멧의 개수
    int m = Integer.parseInt(st.nextToken());       // 조끼의 개수

    int maxN = -1;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int power = Integer.parseInt(st.nextToken());

      if (maxN < power) maxN = power;
    }

    int maxM = -1;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int power = Integer.parseInt(st.nextToken());

      if (maxM < power) maxM = power;
    }

    System.out.println(maxN + maxM);
  }
}
