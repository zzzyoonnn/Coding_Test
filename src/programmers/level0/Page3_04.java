package programmers.level0;
// 간단한 논리 연산

public class Page3_04 {
  public static void main(String[] args) {
    boolean x1 = false;
    boolean x2 = true;
    boolean x3 = true;
    boolean x4 = true;

    boolean answer = (x1 || x2) && (x3 || x4);
    System.out.println(answer);
  }
}
