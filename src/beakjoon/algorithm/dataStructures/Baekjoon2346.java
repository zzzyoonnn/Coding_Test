package beakjoon.algorithm.dataStructures;

import jdk.jshell.execution.JdiExecutionControlProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2346 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Deque<int[]> deque = new ArrayDeque<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) deque.add(new int[] {i + 1, Integer.parseInt(st.nextToken())});

    StringBuilder sb = new StringBuilder();

    while (true) {
      int[] arr = deque.pollFirst();
      int num = arr[1];
      sb.append(arr[0]).append(" ");

      if (deque.isEmpty()) break;

      if (num > 0) {
        for (int i = 0; i < num; i++) {
          deque.offerLast(deque.pollFirst());
        }
      } else {
        for (int i = Math.abs(num); i > 0; i--) {
          deque.addFirst(deque.pollLast());
        }
      }
    }

    System.out.println(sb);
  }
}
