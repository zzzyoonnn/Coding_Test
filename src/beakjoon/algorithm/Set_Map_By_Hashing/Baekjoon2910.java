package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon2910 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 메시지의 길이
    int c = Integer.parseInt(st.nextToken());       // 수열의 최대값

    HashMap<Integer, Integer> map = new HashMap<>();    // Key : 수열의 값, Value : 빈도 수
    ArrayList<Integer> list = new ArrayList<>();        // 수열 정보를 저장할 list
    ArrayList<Integer> order = new ArrayList<>();       // 순서 정보를 저장할 order

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());

      map.put(num, map.getOrDefault(num, 0) + 1);
      list.add(num);
      order.add(list.get(i));
    }

    Collections.sort(list, (o1, o2) -> {                    // list 정렬 시작
      if (map.get(o1) - map.get(o2) == 0) {                 // o1과 o2의 빈도가 같다면
        return order.indexOf(o1) - order.indexOf(o2);       // 먼저 나온 것이 앞에 등장
      } else {                                              // o1과 o2의 빈도가 다르다면
        return Integer.compare(map.get(o2),map.get(o1));    // 많이 등장하는 경우가 앞에 등장
      }
    });

    for (int i = 0; i < n; i++) {
      System.out.print(list.get(i) + " ");
    }
  }
}
