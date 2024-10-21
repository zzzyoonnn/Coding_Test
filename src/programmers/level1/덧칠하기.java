package programmers.level1;

public class 덧칠하기 {
  public static int solution(int n, int m, int[] section) {
    int answer = 0;
    boolean[] wall = new boolean[n + 1];

    for (int i = 0; i < section.length; i++) {
      int num = section[i];

      if (!wall[num]) {
        for (int j = 0; j < m; j++) {
          if (num + j < wall.length) wall[num + j] = true;
        }
        answer++;
      }
    }


    return answer;
  }

  public static void main(String[] args) {
    int n = 8;
    int m = 4;
    int[] section = {2, 3, 6};

    System.out.println(solution(n, m, section));
  }
}
