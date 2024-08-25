package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baeckjoon23253 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<Integer> list;

    boolean check = true;
    for (int i = 0; i < m; i++) {
      list = new ArrayList<>();
      int k = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());

      while (st.hasMoreTokens()) {
        list.add(Integer.parseInt(st.nextToken()));
      }

      for (int j = 1; j < list.size(); j++) {
        if (list.get(j - 1) < list.get(j)) {
          check = false;
          break;
        }
      }
    }

    if (check) System.out.println("Yes");
    else System.out.println("No");

  }
}
