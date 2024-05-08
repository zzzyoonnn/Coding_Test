package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Baekjoon21939 {
  public static class Problem implements Comparable<Problem> {
    int num;        // 문제 번호 
    int level;      // 난이도

    public Problem(int num, int level) {
      this.num = num;
      this.level = level;
    }

    @Override
    public int compareTo(Problem o) {       // 정렬
      if (level - o.level == 0) return num - o.num;     // 난이도가 같으면 문제 번호로 정렬
      else return level - o.level;                      // 문제 번호로 정렬
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 문제의 개수

    TreeSet<Problem> set = new TreeSet<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());     // 문제 번호
      int b = Integer.parseInt(st.nextToken());     // 난이도

      set.add(new Problem(a, b));
      map.put(a,  b);
    }

    int m = Integer.parseInt(br.readLine());        // 명령문의 개수

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      String command = st.nextToken();

      if (command.equals("add")) {
        int a = Integer.parseInt(st.nextToken());     // 문제 번호
        int b = Integer.parseInt(st.nextToken());     // 난이도

        set.add(new Problem(a, b));
        map.put(a,  b);
      }

      if (command.equals("solved")) {
        int a = Integer.parseInt(st.nextToken());     // 문제 번호

        set.remove(new Problem(a, map.get(a)));
        map.remove(a);
      }

      if (command.equals("recommend")) {
        int index = Integer.parseInt(st.nextToken());

        if (index == 1) System.out.println(set.last().num);
        else if (index == -1) System.out.println(set.first().num);
      }
    }
  }
}
