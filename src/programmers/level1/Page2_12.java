package programmers.level1;
// 같은 숫자는 싫어
import java.util.LinkedList;
import java.util.List;

public class Page2_12 {
  public static void main(String[] args) {
    int[] arr = {1, 1, 3, 3, 0, 1, 1};

    List<Integer> list = new LinkedList<>();
    list.add(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != arr[i - 1]) list.add(arr[i]);
    }

    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
      System.out.println(answer[i]);
    }
  }
}
