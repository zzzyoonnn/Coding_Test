package programmers.level0;
// 배열 만들기 3
import java.util.ArrayList;

public class Page4_06 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int[][] intervals = {{1, 3}, {0, 4}};

    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];

      for (int j = start; j <= end; j++) {
        list.add(arr[j]);
      }
    }

    System.out.println(list);
  }
}
