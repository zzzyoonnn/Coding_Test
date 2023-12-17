package programmers.level0;
// 문자 리스트를 문자열로 변환하기

public class Page1_20 {
  public static void main(String[] args) {
    String[] arr = {"a", "b", "c"};
    String s = "";

    for (int i = 0; i < arr.length; i++) {
      s += arr[i];
    }

    System.out.println(s);
  }
}
