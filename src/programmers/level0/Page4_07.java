package programmers.level0;
// 2의 영역
import java.util.ArrayList;
import java.util.Arrays;

public class Page4_07 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 1, 4, 5, 2, 9};
    //int[] arr = {1, 1, 1};
    //int[] arr = {1, 2, 1, 2, 1, 10, 2, 1};

    ArrayList<Integer> list = new ArrayList<>();

    int start = -1;
    int end = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 2 && start == -1) start = i;
      if (arr[arr.length - 1 - i] == 2 && end == -1) end = arr.length - 1 - i;
    }

    if(start == -1 && end == -1) list.add(-1);
    else {
      for (int i = 0; i < end - start + 1; i++) {
        list.add(arr[start + i]);
      }
    }
    int[] answer = list.stream().mapToInt(x -> x).toArray();

    System.out.println(Arrays.toString(answer));
  }
}
