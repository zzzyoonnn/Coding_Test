package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 가장가까운같은글자 {
  public static int[] solution(String s) {
    int[] answer = new int[s.length()];
    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < answer.length; i++) {
      char c = s.charAt(i);
      if (!map.containsKey(c)) {
        answer[i] = -1;
        map.put(c, i);
      } else {
        answer[i] = i - map.get(c);
        map.put(c, i);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
//    String s = "banana";

    String s = "foobar";

//    String s = "aaaaaaaaa";

    System.out.println(Arrays.toString(solution(s)));
  }
}
