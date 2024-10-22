package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 대충만든자판 {
  public static int[] solution(String[] keymap, String[] targets) {
    int[] answer = new int[targets.length];

    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < keymap.length; i++) {
      for (int j = 0; j < keymap[i].length(); j++) {
        char c = keymap[i].charAt(j);
        map.put(c, Math.min(map.getOrDefault(c, 100), j + 1));
      }
    }

    for (int i = 0; i < targets.length; i++) {
      for (int j = 0; j < targets[i].length(); j++) {
        char c = targets[i].charAt(j);

        if (map.containsKey(c)) {
          answer[i] += map.get(c);
        } else {
          answer[i] = -1;
          break;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    String[] keymap = {"ABACD", "BCEFD"};
    String[] targets = {"ABCD","AABB"};

    System.out.println(Arrays.toString(solution(keymap, targets)));
  }
}
