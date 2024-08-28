package beakjoon.algorithm.dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2346 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<Integer>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) list.add(Integer.parseInt(st.nextToken()));

    int index = 0;
    while (!list.isEmpty()) {
      int num = list.get(index);
      System.out.println(list.remove(index));

      if (num > 0) {
        index = (index + num - 1) % list.size();
      } else {
        index = (index - (num % list.size()) + list.size()) % list.size();

      }

    }
  }
}
