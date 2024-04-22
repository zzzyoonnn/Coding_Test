package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon3077 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 해전의 개수

    String[] arr = new String[n];
    HashMap<String, String> map = new HashMap<>();      // Key : 직전의 해전, Value : 직후의 해전

    StringTokenizer st = new StringTokenizer(br.readLine());

    // String배열에 해전을 순서대로 삽입
    for (int i = 0; i < n; i++) {
      arr[i] = st.nextToken();
    }

    // 해전 순서를 map에 넣기
    for (int i = 0; i < n - 1; i++) {
      map.put(arr[i], arr[i + 1]);
    }

    for (String s : map.keySet()) {
      System.out.println(s + " " + map.get(s));
    }

    System.out.println("---------------------------------------");

    // 현우의 정답
    int score = 0;
    st = new StringTokenizer(br.readLine());
    String before = st.nextToken();
    for (int i = 1; i < n; i++) {
      String now = st.nextToken();
      System.out.println(before + " " + now);
      if (map.get(before).equals(now)) score++;

      before = now;
    }

    System.out.println(score);
    System.out.println();
  }
}
