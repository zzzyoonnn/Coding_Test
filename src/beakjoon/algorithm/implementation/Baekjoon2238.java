package beakjoon.algorithm.implementation;
/*
문제
- 경매는 여러 사람이 하나의 물건을 사려고 할 때, 
  각 사람이 원하는 가격을 제시하면 그 중 가장 높은 가격으로 물건을 팔게 되는 방식이다. 
  이러한 고전적인 경매 방식은 꽤 널리 쓰이는데, 최근에는 인터넷 쇼핑몰에서 반대의 경매 방식을 택하기도 한다. 
  즉, 여러 사람이 가격을 제시하면, 그 중 가장 낮은 가격으로 물건을 팔게 되는 방식도 쓰인다.
  하지만 이럴 경우, 모든 사람들이 1원에 물건을 사겠다고 하는 사태가 발생할 수 있다. 
  따라서 같은 가격을 제시한 사람이 둘 이상일 경우에는 무효로 하는 방식이 쓰인다. 
  하지만 모든 가격을 여러 사람이 제시하는 경우도 있을 수 있기 때문에, 다음과 같은 방식으로 경매 당첨자를 선택하기로 한다.
  우선 가장 적은 수의 사람이 제시한 가격을 찾는다. 
  이러한 경우가 여럿 있다면, 가장 낮은 가격으로 물건을 팔게 된다. 
  이때, 그 가격을 제시한 사람들 중에서 가장 먼저 제시한 사람이 물건을 살 수 있게 된다.
  각각의 사람들이 제시한 가격이 주어졌을 때, 경매에 낙찰(당첨)되는 사람을 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 두 정수 U(1 ≤ U ≤ 10,000), N(1 ≤ N ≤ 100,000)이 주어진다. 
  U는 금액의 상한이고, N은 경매에 참여한 회수이다. 
  다음 N개의 줄에는 사람 이름 S(공백 없는 알파벳 대소문자 10자 이하)와, 
  그 사람이 제시한 가격 P(1 ≤ P ≤ U, 정수)이 경매에 참여한(가격을 제시한) 순서대로 주어진다.
출력
- 첫째 줄에 낙찰된 사람의 이름과 그 가격을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon2238 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int u = Integer.parseInt(st.nextToken());   // 금액의 상한
    int n = Integer.parseInt(st.nextToken());   // 경매에 참여한 횟수

    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer, String> map = new HashMap<>();

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();                 // 사람 이름
      int p = Integer.parseInt(st.nextToken());     // 제시한 가격

      map.put(p, name);

      if (set.contains(p)) {
        set.remove(p);

        if (p == min) min = Integer.MAX_VALUE;
        continue;
      }
      else set.add(p);

      if (min > p) min = p;
    }

    System.out.println(map.get(min) + " " + min);
  }
}
