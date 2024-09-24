package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 추억점수 {
  public static int[] solution(String[] name, int[] yearning, String[][] photo) {
    int[] answer = new int[photo.length];

    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < name.length; i++) {
      String s = name[i];
      int score = yearning[i];

      map.put(s, score);
    }

    for (int i = 0; i < photo.length; i++) {
      int sum = 0;

      for (int j = 0; j < photo[i].length; j++) {
        sum += map.getOrDefault(photo[i][j], 0);
      }

      answer[i] = sum;
    }

    return answer;
  }

  public static void main(String[] args) {
//    String[] name = {"may", "kein", "kain", "radi"};
//    int[] yearning = {5, 10, 1, 3};
//    String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

//    String[] name = {"kali", "mari", "don"};
//    int[] yearning = {11, 1, 55};
//    String[][] photo = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};

    String[] name = {"may", "kein", "kain", "radi"};
    int[] yearning = {5, 10, 1, 3};
    String[][] photo = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};

    System.out.println(Arrays.toString(solution(name, yearning, photo)));
  }
}
