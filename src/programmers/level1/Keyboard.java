package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

// 대충 만든 자판

public class Keyboard {
  public static void main(String[] args) {
    //    String[] keymap = {"ABACD", "BCEFD"};   // 할당된 문자들이 순서대로 담긴 문자열배열
    //    String[] targets = {"ABCD", "AABB"};    // 입력하려는 문자열들

    //    String[] keymap = {"AA"};
    //    String[] targets = {"B"};

    String[] keymap = {"AGZ", "BSSS"};
    String[] targets = {"ASA","BGZ"};

    int[] answer = new int[targets.length];

    HashMap<Character, Integer> keyboard = new HashMap<>();

    for (int i = 0; i < keymap.length; i++) {
      for (int j = 0; j < keymap[i].length(); j++) {
        char c = keymap[i].charAt(j);
        int index = j + 1;


        if (keyboard.containsKey(c)) {
          keyboard.put(c, Math.min(index, keyboard.get(c)));
        } else {
          keyboard.put(c, index);
        }
      }
    }

    for (int i = 0; i < targets.length; i++) {
      String target = targets[i];
      boolean check = false;
      int count = 0;

      for (char c : target.toCharArray()) {
        if (keyboard.containsKey(c)) {
          count += keyboard.get(c);
        } else {
          check = true;;
          break;
        }
      }
      if (check) answer[i] = -1;
      else answer[i] = count;
    }

    System.out.println(Arrays.toString(answer));
  }
}
