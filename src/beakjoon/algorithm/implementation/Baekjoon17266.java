package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17266 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 굴다리의 길이
    int m = Integer.parseInt(br.readLine());        // 가로등의 개수
    int[] x = new int[m];       // 가로등 위치
    int height = 0;          // 최소 높이

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      x[i] = Integer.parseInt(st.nextToken());
    }


    int low = 1;        // 굴다리 최소 길이
    int high = n;       // 굴다리 최대 길이

    while (low <= high) {
      int mid = (low + high) / 2;
      boolean flag = true;          // while문을 멈출지 말지

      int spot = 0;     // 이전에 가로등이 비추었던 위치
      for (int i = 0; i < x.length; i++) {
        if (x[i] - mid <= spot) {
          spot = x[i] + mid;
        } else {
          flag = false;
        }
      }

      if (n - spot > 0) flag = false;
      else flag = true;

      if (flag) {
        height = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    System.out.println(height);
  }
}
