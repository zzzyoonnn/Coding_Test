package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon1337 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> list  = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(br.readLine()));
    }

    int min = Integer.MAX_VALUE / 2;
    for (int start = 0; start < list.size(); start++) {
      int count = 0;
      for (int index = 0; index < 5; index++) {
        if (!list.contains(list.get(start) + index)) {
          count++;
        }
      }
      min = Math.min(min, count);
    }
    System.out.print(min);
  }
}
