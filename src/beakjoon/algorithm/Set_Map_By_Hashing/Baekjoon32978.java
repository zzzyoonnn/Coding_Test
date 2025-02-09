package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon32978 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    ArrayList<String> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      list.add(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      String ingredient = st.nextToken();

      if (list.contains(ingredient)) {
        list.remove(ingredient);
      }
    }

    System.out.print(list.get(0));
  }
}
