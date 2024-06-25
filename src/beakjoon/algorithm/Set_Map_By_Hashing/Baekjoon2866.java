package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon2866 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    // 문자열 생성하기, O(rc^2)
    String[] arr = new String[c];
    for (int i = 0; i < r; i++) {
      String s = br.readLine();

      for (int j = 0; j < c; j++) {
        if (i == 0) arr[j] = String.valueOf(s.charAt(j));
        else arr[j] += String.valueOf(s.charAt(j));
      }
    }

    int count = 0;

    // O(r^2 * c)
    for (int j = 1; j < r; j++) {

      // 만들어진 문자열을 쪼갠 문자열을 저장할 HashSet
      HashSet<String> set = new HashSet<>();

      for (int i = 0; i < c; i++) {
        String s = arr[i].substring(j);     // O(r)
        System.out.println(s);

        if (set.contains(s)) {
          System.out.println(j - 1);
          System.exit(0);
        } else {
          set.add(s);
        }
      }
      set.clear();
      count = j;
    }

    System.out.println(count);
  }
}
