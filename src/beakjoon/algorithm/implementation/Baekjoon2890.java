package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Baekjoon2890 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    TreeSet<Integer> set = new TreeSet<>();             // 중복을 제거한 순위를 구하기 위해 TreeSet 사용
    TreeMap<Integer, Integer> map = new TreeMap<>();    // 각 팀별 결승선과의 거리를 저장하기 위한 TreeMap
    char[][] arr = new char[r][c];
    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      for (int j = 1; j < c ; j++) {
        char ch = s.charAt(c - 1 - j);

        // 팀 X
        if (ch == 'S') break;

        // 팀 발견
        if (ch != '.') {
          set.add(j);
          map.put(ch - '0', j);
          break;
        }
      }
    }

    // TreeSet -> ArrayList
    ArrayList<Integer> list = new ArrayList<>(set);

    // 순위를 저장할 HashMap(Key : team, Value : rank)
    HashMap<Integer, Integer> rank = new HashMap<>();

    for (int i = 0; i < list.size(); i++) {
      for (int m : map.keySet()) {
        if (map.get(m) == list.get(i)) {
          rank.put(m, i + 1);
        }
      }
    }

    for (int i = 1; i <= 9; i++) {
      System.out.println(rank.get(i));
    }
  }
}
