package programmers.level0;
// 접미사 배열
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Page3_12 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String my_string = sc.next();

    List<String> list = new ArrayList<>();

    int n = my_string.length();
    for (int i = 0; i < n; i++) {
      list.add(my_string);
      my_string = my_string.substring(1, my_string.length());
    }

    Collections.sort(list);

    System.out.println(list.toString());

  }
}
