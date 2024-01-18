package programmers.level0;
// 가까운 1 찾기

public class Page4_03 {
  public static void main(String[] args) {
    int[] arr = {0, 0, 0, 1};
    int idx = 1;

    int result = 0;

    for (int i = idx; i < arr.length; i++) {
      if (arr[i] == 1) result = i;
    }

    if (result != 0) System.out.println(result);
    else System.out.println(-1);
  }
}
