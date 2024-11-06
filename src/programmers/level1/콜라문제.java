package programmers.level1;

public class 콜라문제 {
  public static int solution(int a, int b, int n) {
    int answer = 0;

    while (n >= a) {
      int count = n / a;
      n %= a;

      int bottle = b * count;
      answer += bottle;
      n += bottle;
    }

    return answer;
  }

  public static void main(String[] args) {
//    int a = 2;
//    int b = 1;
//    int n = 20;

    int a = 3;
    int b = 1;
    int n = 20;

    System.out.println(solution(a, b, n));
  }
}
