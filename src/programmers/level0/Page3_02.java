package programmers.level0;
// 콜라츠 수열 만들기
import java.util.ArrayList;
import java.util.Scanner;

public class Page3_02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> list = new ArrayList<>();
    list.add(n);

    while (true) {
      if (n % 2 == 0) {
        n /= 2;
        list.add(n);
      } else {
        n = (3 * n) + 1;
        list.add(n);
      }

      if (n == 1) break;
    }
    System.out.println(list);
  }
}
