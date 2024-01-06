package programmers.level0;
// 배열 만들기 2
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Page2_20 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int l = sc.nextInt();
    int r = sc.nextInt();

    List<Integer> list = new ArrayList<>();
    boolean check = false;
    for (int i = l; i <= r; i++) {
      String s = Integer.toString(i);
      int count = 0;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == '0' || s.charAt(j) == '5') count++;
        else break;
      }

      if (s.length() == count) {
        list.add(i);
        check = true;
      }
    }

    Object[] arr = list.toArray(); 
    if (arr.length != 0) System.out.println(list);
    else System.out.println(-1);
  }
}
