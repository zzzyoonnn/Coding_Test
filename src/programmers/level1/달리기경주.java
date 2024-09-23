package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 달리기경주 {
  public static String[] solution(String[] players, String[] callings) {
    HashMap<String, Integer> name = new HashMap<>();
    HashMap<Integer, String> rank = new HashMap<>();

    for (int i = 0; i < players.length; i++) {
      name.put(players[i], i);
      rank.put(i, players[i]);
    }

    for (String calling : callings) {
      int n = name.get(calling);    // 호명된 선수 등수
      String outrunedPlayer = rank.get(n - 1);    // 추월당한 선수의 이름

      name.replace(calling, n - 1);
      name.replace(outrunedPlayer, n);

      rank.replace(n - 1, calling);
      rank.replace(n, outrunedPlayer);
    }

    for (int index : rank.keySet()) {
      players[index] = rank.get(index);
    }

    return players;
  }

  public static void main(String[] args) {
    String[] players = {"mumu", "soe", "poe", "kai", "mine"};
    String[] callings = {"kai", "kai", "mine", "mine"};

    System.out.println(Arrays.toString(solution(players, callings)));
  }
}
