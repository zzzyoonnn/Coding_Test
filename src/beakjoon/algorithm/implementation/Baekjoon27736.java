package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon27736 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[3];     // 0: 찬성, 1: 반대, 2: 기권

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int vote = Integer.parseInt(st.nextToken());

      if (vote == 1) arr[0]++;
      else if (vote == -1) arr[1]++;
      else if (vote == 0) arr[2]++;
    }

    if (n % 2 == 1) n++;

    if (arr[2] >= n / 2) {
      System.out.println("INVALID");
      System.exit(0);
    }

    if (arr[0] > arr[1]) System.out.println("APPROVED");
    else System.out.println("REJECTED");

  }
}
