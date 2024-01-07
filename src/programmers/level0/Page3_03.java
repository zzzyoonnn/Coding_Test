package programmers.level0;
// 배열 만들기 4
import java.util.ArrayList;

public class Page3_03 {
  public static void main(String[] args) {
    int[] arr = {1, 4, 2, 5, 3};
    ArrayList<Integer> stk = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (stk.size() == 0) {
        stk.add(arr[i]);
        i++;
      }
      else if (stk.size() != 0 && stk.get(stk.size() - 1) < arr[i]) {
        stk.add(arr[i]);
        i++;
      }
      else if (stk.get(stk.size() - 1) >= arr[i]) stk.remove(stk.size() - 1);
    }

    System.out.println(stk);
  }
}
