package programmers.level0;
// 수열과 구간 쿼리 4
import java.util.Arrays;

public class Page2_19 {
  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 4, 3};
    int[][] queries = {{0, 4, 1}, {0, 3, 2}, {0, 3, 3}};

    for (int i = 0; i < queries.length; i++) {
      int n = queries[i][2];
      for (int j = queries[i][0]; j <= queries[i][1]; j++) {
        if (j % n == 0) arr[j]++;
      }
    }
    System.out.println(Arrays.toString(arr));
  }
}
