package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 총총이는 친구 곰곰이의 소개로 제2회 곰곰컵에 출연할 기회를 얻었다!
  총총이는 자신의 묘기인 무지개 댄스를 선보여, 여러분의 환심을 사려 한다. 
  이 댄스는 중독성이 강하기 때문에, 한번 보게 된 사람은 모두 따라 하게 돼버린다.
  무지개 댄스를 추는 총총 2마리
  사람들이 만난 기록이 시간 순서대로 N개 주어진다. (총총이는 토끼이지만 이 문제에서는 편의상 사람이라고 가정한다.)
  무지개 댄스를 추지 않고 있던 사람이 무지개 댄스를 추고 있던 사람을 만나게 된다면, 만난 시점 이후로 무지개 댄스를 추게 된다.
  기록이 시작되기 이전 무지개 댄스를 추고 있는 사람은 총총이 뿐이라고 할 때, 
  마지막 기록 이후 무지개 댄스를 추는 사람이 몇 명인지 구해보자!
입력
- 첫번째 줄에는 사람들이 만난 기록의 수 N (1 <= N <= 1,000)이 주어진다.
  두번째 줄부터 N개의 줄에 걸쳐 사람들이 만난 기록이 주어진다. 
  i + 1번째 줄에는 i번째로 만난 사람들의 이름 
  Ai와 Bi가 공백을 사이에 두고 주어진다. 
  Ai와 Bi는 숫자와 영문 대소문자로 이루어진 최대 길이 20의 문자열이며, 서로 같지 않다.
  총총이의 이름은 ChongChong으로 주어지며, 기록에서 1회 이상 주어진다.
  동명이인은 없으며, 사람의 이름은 대소문자를 구분한다. (ChongChong과 chongchong은 다른 이름이다.)
출력
- 마지막 기록 이후 무지개 댄스를 추는 사람의 수를 출력하라.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon26069 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());    // 사람들이 만난 기록의 수
    StringTokenizer st;

    HashSet<String> set = new HashSet<>();
    set.add("ChongChong");

    int count = 1;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String name1 = st.nextToken();
      String name2 = st.nextToken();

      if (set.contains(name1)) {
        if (set.contains(name2)) continue;
        else {
          set.add(name2);
          count++;
        }
      } else if (set.contains(name2)) {
        if (set.contains(name1)) continue;
        else {
          set.add(name1);
          count++;
        }
      }
    }
    System.out.println(count);
  }
}
