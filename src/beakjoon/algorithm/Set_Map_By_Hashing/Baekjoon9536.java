package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon9536 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

    for (int tc = 0; tc < t; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      LinkedList<String> list = new LinkedList<>();

      while (st.hasMoreTokens()) {
        list.add(st.nextToken());       // list에 녹음된 울음소리 저장
      }

      String s;
      while (true) {
        s = br.readLine();

        if (s.equals("what does the fox say?")) break;

        st = new StringTokenizer(s);

        String animal = st.nextToken();     // <동물>
        String goes = st.nextToken();
        String ow = st.nextToken();         // <소리>

        while (list.contains(ow)) {     // list에 동물의 울음소리가 있다면
          list.remove(ow);              // 제거
        }   // list의 모든 울음소리가 살아질 때 까지
      }

      for (String sound : list) {
        System.out.print(sound + " ");
      }
      System.out.println();
    }
  }
}
