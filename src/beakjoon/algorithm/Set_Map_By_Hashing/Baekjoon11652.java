package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 준규는 숫자 카드 N장을 가지고 있다. 
  숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.
  준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 
  만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
입력
- 첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 
  둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
출력
- 첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Baekjoon11652 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // 준규가 가지고 있는 카드의 개수

    TreeMap<Long, Integer> map = new TreeMap<>();
    //가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력해야 하므로 TreeMap 사용

    long max = -1;
    String result = "";
    for (int i = 0; i < n; i++) {
      Long l = Long.parseLong(br.readLine());

      if (map.containsKey(l)) map.replace(l, map.get(l) + 1);
      else map.put(l, 1);

      if (map.get(l) > max) {
        max = map.get(l);
      }
    }

    for (long l : map.keySet()) {
      if (map.get(l) == max) {
        System.out.println(l);
        System.exit(0);
      }
    }
  }
}
