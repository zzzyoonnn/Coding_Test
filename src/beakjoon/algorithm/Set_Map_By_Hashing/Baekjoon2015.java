package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon2015 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 배열 A의 길이
    int k = Integer.parseInt(st.nextToken());      // 찾아야 하는 부분 합

    st = new StringTokenizer(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    list.add(0);
    for (int i = 1; i <= n; i++) {
      list.add(Integer.parseInt(st.nextToken()) + list.get(i - 1));
    }
    System.out.println(list);

    HashMap <Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    long count = 0;
    for (int i = 1; i <= n; i++) {
      count += map.getOrDefault(list.get(i) - k, 0);
      map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
    }

    System.out.println(count);
  }
}
