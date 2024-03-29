package programmers.level1;
import java.util.Arrays;
import java.util.HashMap;

public class MemoryScore {
  public static void main(String[] args) {
    String[] name = {"may", "kein", "kain", "radi"};
    int[] yearning = {5, 10, 1, 3};
    String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

    int[] answer = new int[photo.length];

    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < name.length; i++) {
      map.put(name[i], yearning[i]);
    }

    for (int i = 0; i < photo.length; i++) {
      int score = 0;
      for (int j = 0; j < photo[i].length; j++) {
        if (map.get(photo[i][j]) == null) continue;

        score += map.get(photo[i][j]);
      }
      answer[i] = score;
    }
    System.out.println(Arrays.toString(answer));
  }
}
