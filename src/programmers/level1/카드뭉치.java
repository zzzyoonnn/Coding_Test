package programmers.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카드뭉치 {
  public static String solution(String[] cards1, String[] cards2, String[] goal) {
    boolean check = true;

    Queue<String> queue1 = new LinkedList<>();
    Queue<String> queue2 = new LinkedList<>();

    for (int i = 0; i < cards1.length; i++) {
      queue1.add(cards1[i]);
    }

    for (int i = 0; i < cards2.length; i++) {
      queue2.add(cards2[i]);
    }

    for (int i = 0; i < goal.length; i++) {
      String s = goal[i];

      if (!queue1.isEmpty() && queue1.peek().equals(s)) {
        queue1.poll();
        continue;
      }

      if (!queue2.isEmpty() && queue2.peek().equals(s)) {
        queue2.poll();
        continue;
      }

      check = false;
      break;
    }

    return check ? "Yes" : "No";
  }

  public static void main(String[] args) {
    String[] cards1 = {"i", "drink", "water"};
    String[] cards2 = {"want", "to"};
    String[] goal = {"i", "want", "to", "drink", "water"};

    System.out.println(solution(cards1, cards2, goal));
  }
}
