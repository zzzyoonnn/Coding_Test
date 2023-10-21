package programmers.level1;
// 두 개 뽑아서 더하기
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Page3_05 {
  public static void main(String[] args) {
    int[] numbers = {2, 1, 3, 4, 1};
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        set.add(numbers[i] + numbers[j]);
      }
    }
    ArrayList<Integer> list = new ArrayList<>(set);
    Collections.sort(list);

    for (int i = 0; i < list.size(); i++) System.out.println(list.get(i));
  }
}
