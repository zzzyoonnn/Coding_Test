package beakjoon.algorithm.Set_Map_By_Hashing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon22233 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 키워드 개수
    int m = Integer.parseInt(st.nextToken());       // 블로그에 쓴 글의 개수

    HashSet<String> set = new HashSet<>();          // 키워드 정보를 저장할 HashSet

    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), ",");

      while (st.hasMoreTokens()) {
        String word = st.nextToken();

        if (set.contains(word)) set.remove(word);
      }

      System.out.println(set.size());
    }
  }
}