package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon1920 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    // 주어지는 수를 저장할 HashSet
    HashSet<Integer> set = new HashSet<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (set.contains(num)) System.out.println(1);
      else System.out.println(0);
    }
  }
}
