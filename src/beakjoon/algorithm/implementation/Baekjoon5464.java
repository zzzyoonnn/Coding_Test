package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon5464 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of parking spaces
    int m = Integer.parseInt(st.nextToken());   // car's count

    // parking fee per spaces
    int[] parkingFee = new int[n + 1];
    int[] parkingStatus = new int[n + 1];
    for (int i = 1; i <= n; i++) parkingFee[i] = Integer.parseInt(br.readLine());

    // car's weight
    int[] carWeight = new int[m + 1];
    for (int i = 1; i <= m; i++) {
      carWeight[i] = Integer.parseInt(br.readLine());
    }

    // Calculate parking fee
    int total = 0;
    Queue<Integer> queue = new LinkedList<>();

    outer: for (int i = 0; i < m * 2; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num > 0) {
        for (int index = 1; index < parkingStatus.length; index++) {
          if (parkingStatus[index] == 0) {
            parkingStatus[index] = num;
            continue outer;
          }
        }
        queue.add(num);
      } else {
        num *= (-1);
        for (int j = 1; j < parkingFee.length; j++) {
          if (parkingStatus[j] == num) {
            parkingStatus[j] = 0;
            total += parkingFee[j] * carWeight[num];

            if (!queue.isEmpty()) parkingStatus[j] = queue.poll();
          }
        }
      }
    }

    System.out.println(total);
  }
}
