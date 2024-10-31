package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon20920 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of words
    int m = Integer.parseInt(st.nextToken());   // standard of length

    HashMap<String, Integer> map = new HashMap<String, Integer>();

    for (int i = 1; i <= n; i++) {
      String word = br.readLine();

      if (word.length() < m) continue;

      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    ArrayList<String> list = new ArrayList<>(map.keySet());

    Collections.sort(list, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        // 자주 등장하는 단어 순서대로 정렬
        if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
          return Integer.compare(map.get(o2), map.get(o1));
        }

        // 등장 횟수가 같으면 긴 단어 먼저
        if (o1.length() != o2.length()) {
          return o2.length() - o1.length();
        }

        // 등장 횟수와 단어의 길이가 같으면 사전 순으로 정렬
        return o1.compareTo(o2);
      }
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i)).append('\n');
    }

    System.out.println(sb.toString());
  }
}
