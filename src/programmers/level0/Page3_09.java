package programmers.level0;
// 배열 만들기 5
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Page3_09 {
  public static void main(String[] args) {
    String[] intStrs = {"0123456789", "9876543210", "9999999999999"};
    int k = 50000;
    int s = 5;
    int l = 5;
    List<Integer> list = new ArrayList<>();
    int count = 0;

    for (int i = 0; i < intStrs.length; i++) {
      String str = intStrs[i];
      str = str.substring(s, s + l);
      int n = Integer.parseInt(str);
      if (n > k) {
        list.add(n);
        count++;
      }
    }

    int[] answer = new int[count];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = list.get(i);
    }
    System.out.println(Arrays.toString(answer));
  }
}
