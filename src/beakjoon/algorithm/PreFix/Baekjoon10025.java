package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10025 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int maxPos = 0;
    int[] arr = new int[1000001];       // 얼음 양동이들의 좌표

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int g = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      arr[x] += g;
    }

    // 첫 번째 윈도우 범위 내 값
    int sum = 0;
    for (int i = 0; i < 1 + 2 * k && i <= 1000000; i++) {
      sum += arr[i];
    }

    int max = sum;
    // 슬라이딩 윈도우 시작
    for (int i = 1 + 2 * k, j = 0; i < arr.length; i++, j++) {
      sum -= arr[j];
      sum += arr[i];

      if (sum > max) max = sum;
    }

    System.out.println(max);
  }
}
