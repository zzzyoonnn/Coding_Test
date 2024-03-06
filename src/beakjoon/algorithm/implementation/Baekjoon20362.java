package beakjoon.algorithm.implementation;
/*
문제
- 올해 인천대에서는 코로나19로 인해 온라인 축제를 개최했다. 
  축제 내용 중에는 퀴즈쇼가 있는데, 초청 연예인이 채팅을 보고 정답을 맞힌 사람의 닉네임을 읽어 1명에게 상품을 주는 이벤트이다.
  축제를 즐기던 철이는 퀴즈쇼가 끝난 뒤 커뮤니티에 당첨자보다 정답을 빨리 쳤다며 아쉬워하는 사람들이 나타난 것을 보았다. 
  채팅 기록을 갖고 있는 철이는 그런 아쉬운 사람들이 몇 명이나 있는지 알고 싶어졌다. 
  채팅 기록은 여러 줄로 이루어져 있는데, 각 줄에는 채팅을 친 사람의 닉네임과 채팅 내용이 담겨있다.
  채팅 기록과 당첨자가 주어졌을 때 아쉬운 사람의 수를 구해보자. 
  아쉬운 사람은 당첨자보다 빨리 정답을 외친 사람이다.
입력
- 첫 번째 줄에 채팅 개수 N과 정답자의 닉네임 S가 공백으로 구분되어 주어진다. (2 ≤ N ≤ 1,000)
  두 번째 줄부터 차례로 N개의 채팅 기록이 시간순으로 주어진다. 
  채팅 기록은 닉네임과 채팅 내용이 공백으로 구분되어 주어진다. 
  각 닉네임과 채팅 내용은 길이가 1이상 10이하이며 알파벳 소문자로만 이루어져 있다.
  한 사람이 두 번 이상 채팅을 친 경우는 주어지지 않으며, 정답자의 닉네임 S는 반드시 채팅 기록에 등장한다.
출력
- 첫 번째 줄에 아쉬운 사람의 명수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon20362 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // 채팅 개수
    String correct = st.nextToken();  // 정답자의 닉네임

    HashMap<String, Integer> map = new HashMap<>();

    for (int i =0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String nickname = st.nextToken();
      String text = st.nextToken();

      if (nickname.equals(correct)) {
        if (map.get(text) == null) System.out.println(0);
        else System.out.println(map.get(text));
        break;
      }

      if (map.containsKey(text)) map.replace(text, map.get(text) + 1);
      else map.put(text, 1);
    }
  }
}
