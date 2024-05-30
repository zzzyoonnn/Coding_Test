package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10431 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int p = Integer.parseInt(br.readLine());        // 테스트 케이스의 수

    StringTokenizer st;
    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());       // 테스트 케이스 번호

      int count = 0;

      int[] arr = new int[20];
      for (int j = 0; j < 20; j++) {
        arr[j] = Integer.parseInt(st.nextToken());

        for (int k = 0; k < j; k++) {
          if (arr[k] > arr[j]) count++;
        }
      }

      System.out.println(num + " " + count);
    }
  }
}
