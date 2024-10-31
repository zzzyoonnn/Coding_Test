package programmers.level1;

import java.util.ArrayList;

public class 햄버거만들기 {
  public static int solution(int[] ingredient) {
    int answer = 0;

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < ingredient.length; i++) {
      list.add(ingredient[i]);

      int size = list.size() - 1;
      if (size >= 3) {
        if (list.get(size) == 1 && list.get(size - 1) == 3 && list.get(size - 2) == 2 && list.get(size - 3) == 1) {
          list.remove(size);
          list.remove(size - 1);
          list.remove(size - 2);
          list.remove(size - 3);

          answer++;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
    //int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};

    System.out.println(solution(ingredient));
  }
}
