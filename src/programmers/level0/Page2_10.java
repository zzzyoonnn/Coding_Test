package programmers.level0;
// 등차수열의 특정한 항만 더하기

public class Page2_10 {
  public static void main(String[] args) {
    int a = 3;
    int d = 4;
    boolean[] included = {true, false, false, true, true};
    int answer = 0;
    int num = a;

    for (int i = 0; i < included.length; i++) {
      if (included[i] == true) answer += num;
      num += d;
    }
    System.out.println(answer);
  }
}
