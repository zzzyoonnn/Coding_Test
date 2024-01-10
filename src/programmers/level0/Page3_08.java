package programmers.level0;
// 문자열 여러 번 뒤집기

public class Page3_08 {
  public static void main(String[] args) {
    String my_string = "rermgorpsam";
    int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
    char[] arr = my_string.toCharArray();

    for (int i = 0; i < queries.length; i++) {
      int start = queries[i][0];
      int end = queries[i][1];

      while (start < end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        start++;
        end--;
      }
    }
    System.out.println(new String(arr));
  }
}
