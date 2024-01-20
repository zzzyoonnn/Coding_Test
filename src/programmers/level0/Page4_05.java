package programmers.level0;
// 첫 번째로 나오는 음수

public class Page4_05 {
  public static void main(String[] args) {
    //int[] num_list = {12, 4, 15, 46, 38, -2, 15};
    int[] num_list = {13, 22, 53, 24, 15, 6};

    for (int i = 0; i < num_list.length; i++) {
      if (num_list[i] < 0) {
        System.out.println(i);
        break;
      };
    }

    System.out.println(-1);
  }
}
