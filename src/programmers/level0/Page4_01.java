package programmers.level0;
// 글자 지우기
import java.util.Arrays;

public class Page4_01 {
  public static void main(String[] args) {
    String my_string = "apporoograpemmemprs";
    int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};

    Arrays.sort(indices);
    StringBuilder sb = new StringBuilder(my_string);
    for (int i = indices.length - 1; i >= 0; i--) {
      int index = indices[i];
      if (index < sb.length()) {
        sb.deleteCharAt(index);
      }
    }

    System.out.println(sb.toString());
  }
}
