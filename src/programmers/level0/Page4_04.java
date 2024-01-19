package programmers.level0;
// 리스트 자르기
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Page4_04 {
  public static void main(String[] args) {
    int n = 3;
    int[] slicer = {1, 5, 2};
    int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    List<Integer> list = new ArrayList<>();
    int a = slicer[0];
    int b = slicer[1];
    int c = slicer[2];
    if(n == 1) {
      for(int i =0; i<b+1; i++) {
        list.add(num_list[i]);
      }
    } else if(n == 2) {
      for(int i = a; i<num_list.length; i++) {
        list.add(num_list[i]);
      }
    } else if(n ==3) {
      for(int i = a; i<b+1; i++) {
        list.add(num_list[i]);
      }
    } else if(n == 4) {
      for(int i = a; i<b+1; i+=c) {
        list.add(num_list[i]);

      }
    }
    int[] answer = list.stream().mapToInt(x -> x).toArray();
    System.out.println(Arrays.toString(answer));
  }
}
