package programmers.level0;
// 수열과 구간 쿼리 3
import java.util.Arrays;

public class Page2_17 {
  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3, 4};
    int[][] queries = {{0, 3}, {1, 2}, {1, 4}};

    for (int i = 0; i < queries.length; i++) {
      int n = arr[queries[i][0]];
      arr[queries[i][0]] = arr[queries[i][1]];
      arr[queries[i][1]] = n;
    }
    System.out.println(Arrays.toString(arr));
  }
}
