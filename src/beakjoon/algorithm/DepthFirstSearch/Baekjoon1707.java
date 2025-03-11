package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon1707 {
  static int v, e;
  static ArrayList<ArrayList<Integer>> list;
  static int[] check;
  static boolean answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int tc = 0; tc < T; tc++) {
      st = new StringTokenizer(br.readLine());
      v = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());

      list = new ArrayList<>();
      for (int i = 0; i <= v; i++) {
        list.add(new ArrayList<>());
      }

      check = new int[v + 1];
      answer = false;

      for (int i = 0; i < e; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        list.get(a).add(b);
        list.get(b).add(a);
      }

      for (int i = 1; i <= v; i++) {
        if (check[i] == 0) {
          DFS(i, 1);
        }
      }

      if (answer) System.out.println("NO");
      else System.out.println("YES");
    }
  }

  private static void DFS(int v, int group) {
    if (answer) return;

    check[v] = group;
    for (int x : list.get(v)) {
      if (check[x] == group) {
        answer = true;
      } else if (check[x] == 0) {
        DFS(x, group * (- 1));
      }
    }
  }
}
