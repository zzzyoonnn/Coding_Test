package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 상근이와 선영이는 동시에 가지고 있는 CD를 팔려고 한다. 
  CD를 몇 개나 팔 수 있을까?
입력
- 입력은 여러 개의 테스트 케이스로 이루어져 있다. 
  각 테스트 케이스의 첫째 줄에는 상근이가 가지고 있는 CD의 수 N, 선영이가 가지고 있는 CD의 수 M이 주어진다. 
  N과 M은 최대 백만이다. 
  다음 줄부터 N개 줄에는 상근이가 가지고 있는 CD의 번호가 오름차순으로 주어진다. 
  다음 M개 줄에는 선영이가 가지고 있는 CD의 번호가 오름차순으로 주어진다. 
  CD의 번호는 십억을 넘지 않는 양의 정수이다. 
  입력의 마지막 줄에는 0 0이 주어진다.
  상근이와 선영이가 같은 CD를 여러장 가지고 있는 경우는 없다.
출력
- 두 사람이 동시에 가지고 있는 CD의 개수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon4158 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n, m;
    int count;

    HashSet<Integer> set = new HashSet<>();

    while(true) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      if (n == 0 && m == 0) break;

      for (int i = 0; i < n; i++) {
        set.add(Integer.parseInt(br.readLine()));
      }

      count = 0;
      for (int i = 0; i < m; i++) {
        int num = Integer.parseInt(br.readLine());

        if (set.contains(num)) count++;
      }

      System.out.println(count);

      set.clear();
    }
  }
}
