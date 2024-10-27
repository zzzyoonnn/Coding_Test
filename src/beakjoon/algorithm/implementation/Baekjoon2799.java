package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2799 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int[] answer = new int[5];
    br.readLine();
    for (int i = 0; i < m; i++) {
      int[] count = new int[n];
      for (int j = 0; j < 5; j++) {
        String[] windows = br.readLine().split("#");
        for (int k = 0; k < windows.length; k++) {
          if (windows[k].equals("****")) count[k - 1]++;
        }
      }
      for (int index : count) {
        answer[index]++;
      }
    }

    for (int i = 0; i < answer.length; i++) {
      System.out.print(answer[i] + " ");
    }
  }
}
