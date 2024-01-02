package programmers.level0;
// 원소들의 곱과 합

public class Page2_12 {
  public static void main(String[] args) {
    int[] num_list = {3, 4, 5, 2, 1};
    int answer = 0;

    int sum = 0;
    int multiple = 1;

    for (int i = 0; i < num_list.length; i++) {
      sum += num_list[i];
      multiple *= num_list[i];
    }

    sum *= sum;

    if (multiple < sum) System.out.println(1);
    else System.out.println(0);
  }
}
