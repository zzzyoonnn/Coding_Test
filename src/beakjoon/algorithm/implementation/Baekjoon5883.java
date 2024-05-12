package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Baekjoon5883 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());     // 아이폰을 구매하려는 사람들

    HashSet<Integer> set = new HashSet<>();
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      list.add(num);

      if (!set.contains(num)) set.add(num);
    }

    int max = 1;
    for (int i : set) {
      int before = list.get(0);
      int length = 1;

      for (int j = 1; j < list.size(); j++) {
        if (list.get(j) == i) continue;

        int now = list.get(j);
        if (before == now) {
          length++;
          max = Math.max(max, length);
        } else {
          length = 1;
        }
        before = now;
      }
    }
    System.out.println(max);
  }
}
