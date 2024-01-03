package programmers.level0;
// 마지막 두 원소
import java.util.ArrayList;
import java.util.List;

public class Page2_14 {
  public static void main(String[] args) {
    int[] num_list = {2, 1, 6};
    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < num_list.length; i++) {
      answer.add(num_list[i]);
    }

    int n = num_list[num_list.length - 1];  // 마지막 원소
    int m = num_list[num_list.length - 2];  // 그 전 원소

    if (n > m) answer.add(n - m);
    else answer.add(n * 2);

    System.out.println(answer);
  }
}
