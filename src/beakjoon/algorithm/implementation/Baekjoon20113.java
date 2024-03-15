package beakjoon.algorithm.implementation;
/*
문제
- 임포스터는 누구인가?
  플레이어들이 긴급 회의를 위해 한 자리에 모였다. 
  이들은 긴급 회의에서 투표를 통해 임포스터로 의심되는 플레이어 1명을 퇴출시키려고 한다.
  N명의 플레이어들 중 오직 1명만 '임포스터'이고, 나머지는 '크루원'이다. 
  플레이어들은 다른 플레이어가 임포스터인지 크루원인지 모르는 상태이다.
  플레이어들은 각자 플레이어 1명을 투표하거나, 투표를 건너뛸 수 있다. 
  가장 표를 많이 받은 사람이 퇴출된다. 
  표를 가장 많이 받은 사람이 둘 이상이라면, 
  아무도 퇴출되지 않는다.
  투표를 건너뛴 사람 수가 표를 가장 많이 받은 사람의 받은 표 수 이상일 경우에도 표를 가장 많이 받은 사람이 퇴출된다.
  각 플레이어들의 투표 결과가 주어진다. 
  퇴출되는 사람은 누구일까? 
입력
- 첫째 줄에 플레이어의 수 N이 주어진다. (3 ≤ N ≤ 100)  
  둘째 줄에 N개의 정수가 공백으로 구분되어 주어진다. 
  i번째 정수 Xi는 i번 플레이어가 Xi번 플레이어에 투표했음을 의미한다. 
  Xi가 0이면 i번 플레이어가 투표를 건너뛰었음을 의미한다. 
출력
- 투표 결과 퇴출되는 플레이어의 번호를 출력한다.  
  아무도 퇴출되지 않는다면, "skipped" (따옴표 제외)를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon20113 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // 플레이어의 수
    StringTokenizer st = new StringTokenizer(br.readLine());

    HashMap<String, Integer> map = new HashMap<>();

    int max = -1;
    for (int i = 0; i < n; i++) {
      String s = st.nextToken();
      if (s.equals("0")) continue;

      if (map.containsKey(s)) map.replace(s, map.get(s) + 1);
      else map.put(s, 1);

      if (max < map.get(s)) max = map.get(s);
    }

    int count = 0;
    String result = "";
    for (String s : map.keySet()) {
      if (map.get(s) == max) {
        count++;
        result = s;
      }
    }
    if (count == 1) System.out.println(result);
    else System.out.println("skipped");
  }
}
