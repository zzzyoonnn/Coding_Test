package programmers.level0;
// 코드 처리하기

public class Page2_09 {
  public static void main(String[] args) {
    String code = "abc1abc1abc";
    //String code = ""
    String answer = "";
    int mode = 0;

    for (int idx = 0; idx < code.length(); idx++) {
      if (mode == 0) {
        if (code.charAt(idx) == '1') mode = 1;
        else {
          if (idx % 2 == 0) answer += code.charAt(idx);
        }
      } else {
        if (code.charAt(idx) == '1') mode = 0;
        else {
          if (idx % 2 != 0) answer += code.charAt(idx);
        }
      }
    }
    System.out.println(answer.equals("") ? "EMPTY" : answer);
  }
}
